package com.example.pokedex.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.compose.AsyncImage
import coil3.compose.rememberAsyncImagePainter
import coil3.compose.AsyncImagePainter
import com.example.pokedex.data.Pokemon
import com.example.pokedex.location.LocationViewModel
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.Typography
import com.example.pokedex.ui.UiState
import com.example.pokedex.ui.details.components.*
import dev.icerock.moko.geo.compose.BindLocationTrackerEffect
import dev.icerock.moko.permissions.compose.BindEffect
import org.koin.compose.viewmodel.koinViewModel
import com.example.pokedex.camera.rememberCameraLauncher
import org.jetbrains.compose.resources.painterResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.local

@Composable
fun PokemonDetailScreen(
    pokemonId: Int, // Recebe o ID do Pokémon para buscar os detalhes
    viewModel: PokemonDetailViewModel, // ViewModel para buscar HTTP
    onBackClick: () -> Unit,
    onViewTeamClick: () -> Unit = {},
    isInTeam: Boolean = false,
    showTeamFullAlert: Boolean = false,
    onDismissTeamFullAlert: () -> Unit = {},
    teamSize: Int = 0,
    teamPhotoPath: String? = null,
    teamLatitude: Double? = null,
    teamLongitude: Double? = null,
    locationViewModel: LocationViewModel = koinViewModel()
) {
    val uiState by viewModel.detailState.collectAsStateWithLifecycle()
    val locationState by locationViewModel.locationState.collectAsStateWithLifecycle()
    val locationPermissionStatus by locationViewModel.permissionStatus.collectAsStateWithLifecycle()
    val isLoadingLocation by locationViewModel.isLoadingLocation.collectAsStateWithLifecycle()

    var showCaptureDialog by remember { mutableStateOf(false) }
    var capturePhotoPath by remember { mutableStateOf<String?>(null) }
    var showLocalFullTeamAlert by remember { mutableStateOf(false) }

    val isTeamFull = teamSize >= 6

    BindEffect(locationViewModel.controller)
    BindLocationTrackerEffect(locationViewModel.locationTracker)

    // Lançador da câmera nativa (gerencia permissão internamente:
    // no Android verifica/requisita CAMERA antes do TakePicture,
    // no iOS o UIImagePickerController já trata a permissão nativamente)
    val cameraLauncher = rememberCameraLauncher { path ->
        capturePhotoPath = path
    }

    // Dispara a requisição HTTP direta ao abrir a tela
    LaunchedEffect(pokemonId) {
        viewModel.fetchPokemonDetails(pokemonId)
    }

    // Alerta de Time Cheio
    if (showTeamFullAlert) {
        FullTeamAlert(onDismiss = onDismissTeamFullAlert)
    }
    if (showLocalFullTeamAlert) {
        FullTeamAlert(onDismiss = { showLocalFullTeamAlert = false })
    }

    // Pop-Up com GPS e câmera para captura do Pokémon
    if (showCaptureDialog) {
        CaptureLocationDialog(
            latitude = locationState?.latitude,
            longitude = locationState?.longitude,
            permissionStatus = locationPermissionStatus,
            isLoadingLocation = isLoadingLocation,
            onRequestLocationPermission = { locationViewModel.requestLocationPermission() },
            onOpenSettings = { locationViewModel.openSettings() },
            photoPath   = capturePhotoPath,
            onTakePhoto = { cameraLauncher() },
            onConfirm   = { lat, lng ->
                if (uiState is UiState.Success) {
                    val details = (uiState as UiState.Success).data.dto

                    val hp = details.stats.find { it.stat.name == "hp" }?.base_stat ?: 0
                    val attack = details.stats.find { it.stat.name == "attack" }?.base_stat ?: 0
                    val defense = details.stats.find { it.stat.name == "defense" }?.base_stat ?: 0
                    val speed = details.stats.find { it.stat.name == "speed" }?.base_stat ?: 0
                    val typesString = details.types.joinToString(",") { it.type.name }

                    val gpsLocation = if (lat != null && lng != null) {
                        "Lat: $lat, Lng: $lng"
                    } else "GPS Location"

                    viewModel.saveToTeam(
                        id              = details.id,
                        name            = details.name,
                        imageUrl        = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${details.id}.png",
                        captureLocation = gpsLocation,
                        types           = typesString,
                        hp              = hp,
                        attack          = attack,
                        defense         = defense,
                        speed           = speed,
                        latitude        = lat,
                        longitude       = lng,
                        photoPath       = capturePhotoPath
                    )
                }
                showCaptureDialog = false
                capturePhotoPath  = null
            },
            onDismiss = {
                showCaptureDialog = false
                capturePhotoPath = null
            }
        )
    }

    // Renderiza a UI com base no estado atual (Loading, Error ou Success)
    when (val state = uiState) {
        is UiState.Loading -> {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Brush.verticalGradient(listOf(ThemeColors.topBackground, ThemeColors.bottomBackground))),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Color.White)
            }
        }
        is UiState.Error -> {
            Column(
                modifier            = Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(ThemeColors.topBackground, ThemeColors.bottomBackground))).padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Falha de Rede: ${state.message}", color = Color.White)
                Button(onClick = onBackClick) { Text("Voltar") }
            }
        }
        is UiState.Success -> {
            val fullDetails = state.data
            val detailsDto = fullDetails.dto

            // Mapeamento dos dados da API para a classe Pokemon usada na UI
            val mappedPokemon = Pokemon(
                id        = detailsDto.id,
                name      = detailsDto.name,
                imageUrl  = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${detailsDto.id}.png",
                types     = detailsDto.types.map { it.type.name },
                height    = detailsDto.height.toDouble() / 10.0,
                weight    = detailsDto.weight.toDouble() / 10.0,
                abilities = detailsDto.abilities.map { it.ability.name.replace("-", " ") },
                stats     = detailsDto.stats.map {
                    com.example.pokedex.data.Stat(name = it.stat.name, value = it.base_stat)
                },
                description = fullDetails.description,
                weaknesses  = fullDetails.weaknesses,
                gender      = fullDetails.gender,
                evolutions  = fullDetails.evolutions
            )

            // Layout principal da tela de detalhes
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(listOf(ThemeColors.topBackground, ThemeColors.bottomBackground))
                    )
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Spacer(modifier = Modifier.height(80.dp))
                PokemonCard(pokemon = mappedPokemon)

                // Card com foto e coordenadas do Pokémon capturado no time
                if (isInTeam && (teamPhotoPath != null || teamLatitude != null || teamLongitude != null)) {
                    CapturedInfoCard(
                        photoPath = teamPhotoPath,
                        latitude = teamLatitude,
                        longitude = teamLongitude
                    )
                }

                DescriptionCard(pokemon = mappedPokemon)
                PhysicalInfoCard(pokemon = mappedPokemon)
                StatsCard(pokemon = mappedPokemon)
                AbilitiesCard(pokemon = mappedPokemon)
                WeaknessesCard(pokemon = mappedPokemon)
                EvolutionChainCard(pokemon = mappedPokemon)

                TeamActionButtons(
                    onAddToTeamClick = {
                        if (isTeamFull) showLocalFullTeamAlert = true
                        else showCaptureDialog = true
                    },
                    onViewTeamClick  = { onViewTeamClick() },
                    isInTeam         = isInTeam,
                    isTeamFull       = isTeamFull
                )

                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}

// Exibe foto (mantida igual ao original) e o mapa ao lado, no lugar das coordenadas
@Composable
private fun CapturedInfoCard(
    photoPath: String?,
    latitude: Double?,
    longitude: Double?
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = ThemeColors.lightIceGreen.copy(alpha = 0.6f)),
        border = androidx.compose.foundation.BorderStroke(2.dp, ThemeColors.deepGreen.copy(alpha = 0.2f))
    ) {
        Row(
            modifier = Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Foto do Pokémon capturado (inalterada)
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .border(2.dp, ThemeColors.deepGreen.copy(alpha = 0.3f), RoundedCornerShape(16.dp))
                    .background(ThemeColors.iceGreen),
                contentAlignment = Alignment.Center
            ) {
                if (photoPath != null) {
                    AsyncImage(
                        model = photoPath,
                        contentDescription = "Captured photo",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = "Location placeholder",
                        modifier = Modifier.size(50.dp),
                        tint = ThemeColors.deepGreen.copy(alpha = 0.4f)
                    )
                }
            }

            // Mapa no lugar onde antes ficavam as coordenadas
            if (latitude != null && longitude != null) {
                val uriHandler = androidx.compose.ui.platform.LocalUriHandler.current
                // Yandex Maps (longitude, latitude) - Gratuito e mais estável para previews
                val mapUrl = "https://static-maps.yandex.ru/1.x/?ll=$longitude,$latitude&z=14&l=map&size=450,250"

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(6.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "CAPTURE LOCATION",
                        color = ThemeColors.deepGreen,
                        style = Typography.pixelCardTitle(),
                        fontSize = 11.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 0.5.sp,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )

                    // Usando rememberAsyncImagePainter para controlar a visibilidade baseada no sucesso
                    val mapPainter = rememberAsyncImagePainter(model = mapUrl)
                    val mapState by mapPainter.state.collectAsState()

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .border(2.dp, ThemeColors.deepGreen.copy(alpha = 0.3f), RoundedCornerShape(12.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        if (mapState is AsyncImagePainter.State.Success) {
                            Image(
                                painter = mapPainter,
                                contentDescription = "Map",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )
                            Icon(
                                imageVector = Icons.Default.LocationOn,
                                contentDescription = "Pin",
                                modifier = Modifier.size(18.dp),
                                tint = ThemeColors.deepGreen
                            )
                        } else {
                            CircularProgressIndicator(
                                color = ThemeColors.greenPrimary,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }

                    TextButton(
                        onClick = { uriHandler.openUri("geo:$latitude,$longitude?q=$latitude,$longitude") },
                        modifier = Modifier.fillMaxWidth().height(32.dp),
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = "VIEW ON MAP",
                            color = ThemeColors.greenPrimary,
                            style = Typography.pixelCardTitle(),
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            }
        }
    }
}
