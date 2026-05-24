package com.example.pokedex.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.UiState
import com.example.pokedex.ui.details.components.*

@Composable
fun PokemonDetailScreen(
    pokemonId: Int, // Recebe o ID do Pokémon para buscar os detalhes
    viewModel: PokemonDetailViewModel, // ViewModel para buscar HTTP
    onBackClick: () -> Unit,
    onViewTeamClick: () -> Unit = {},
    isInTeam: Boolean = false,
    showTeamFullAlert: Boolean = false,
    onDismissTeamFullAlert: () -> Unit = {}
) {
    val uiState by viewModel.detailState.collectAsState()
    var showCaptureDialog by remember { mutableStateOf(false) }
    var captureLocation by remember { mutableStateOf("") }

    // Dispara a requisição HTTP direta ao abrir a tela
    LaunchedEffect(pokemonId) {
        viewModel.fetchPokemonDetails(pokemonId)
    }

    // Alerta de Time Cheio
    if (showTeamFullAlert) {
        FullTeamAlert(onDismiss = onDismissTeamFullAlert)
    }

    // Pop-Up com input para o local de captura
    if (showCaptureDialog) {
        CaptureLocationDialog(
            location         = captureLocation,
            onLocationChange = { captureLocation = it },
            onConfirm        = {
                if (captureLocation.isNotBlank()) {
                    if (uiState is UiState.Success) {
                        val details = (uiState as UiState.Success).data.dto
                        
                        // Busca os stats reais para salvar no BD
                        val hp = details.stats.find { it.stat.name == "hp" }?.base_stat ?: 0
                        val attack = details.stats.find { it.stat.name == "attack" }?.base_stat ?: 0
                        val defense = details.stats.find { it.stat.name == "defense" }?.base_stat ?: 0
                        val speed = details.stats.find { it.stat.name == "speed" }?.base_stat ?: 0
                        val typesString = details.types.joinToString(",") { it.type.name }

                        viewModel.saveToTeam(
                            id              = details.id,
                            name            = details.name,
                            imageUrl        = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${details.id}.png",
                            captureLocation = captureLocation,
                            types           = typesString,
                            hp              = hp,
                            attack          = attack,
                            defense         = defense,
                            speed           = speed
                        )
                    }
                    showCaptureDialog = false
                    captureLocation   = ""
                }
            },
            onDismiss = { showCaptureDialog = false }
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
                DescriptionCard(pokemon = mappedPokemon)
                PhysicalInfoCard(pokemon = mappedPokemon)
                StatsCard(pokemon = mappedPokemon)
                AbilitiesCard(pokemon = mappedPokemon)
                WeaknessesCard(pokemon = mappedPokemon)
                EvolutionChainCard(pokemon = mappedPokemon)

                TeamActionButtons(
                    onAddToTeamClick = { showCaptureDialog = true },
                    onViewTeamClick  = { onViewTeamClick() },
                    isInTeam         = isInTeam
                )

                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}
