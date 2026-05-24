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
    pokemonId: Int, // Agora recebemos o ID da Rota
    viewModel: PokemonDetailViewModel, // ViewModel para buscar HTTP
    onBackClick: () -> Unit,
    onViewTeamClick: () -> Unit = {},
    isInTeam: Boolean = false,
    showTeamFullAlert: Boolean = false,
    onDismissTeamFullAlert: () -> Unit = {}
) {
    // 1. Estados Reativos
    val uiState by viewModel.detailState.collectAsState()

    // 2. Estados para a Nova Regra de Negócio (Local de Captura)
    var showCaptureDialog by remember { mutableStateOf(false) }
    var captureLocation by remember { mutableStateOf("") }

    // 3. Dispara a requisição HTTP direta ao abrir a tela (ignora banco local)
    LaunchedEffect(pokemonId) {
        viewModel.fetchPokemonDetails(pokemonId)
    }

    // Alerta de Time Cheio Original
    if (showTeamFullAlert) {
        FullTeamAlert(onDismiss = onDismissTeamFullAlert)
    }

    // Regra de Negócio: Onde o Pokemon foi capturado?
    if (showCaptureDialog) {
        CaptureLocationDialog(
            location = captureLocation,
            onLocationChange = { captureLocation = it },
            onConfirm = {
                if (captureLocation.isNotBlank()) {
                    if (uiState is UiState.Success) {
                        val details = (uiState as UiState.Success).data.dto
                        
                        // Busca os stats reais para salvar no banco
                        val hp = details.stats.find { it.stat.name == "hp" }?.base_stat ?: 0
                        val attack = details.stats.find { it.stat.name == "attack" }?.base_stat ?: 0
                        val defense = details.stats.find { it.stat.name == "defense" }?.base_stat ?: 0
                        val speed = details.stats.find { it.stat.name == "speed" }?.base_stat ?: 0
                        val typesString = details.types.joinToString(",") { it.type.name }

                        viewModel.saveToTeam(
                            id = details.id,
                            name = details.name,
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${details.id}.png",
                            captureLocation = captureLocation,
                            types = typesString,
                            hp = hp,
                            attack = attack,
                            defense = defense,
                            speed = speed
                        )
                    }
                    showCaptureDialog = false
                    captureLocation = ""
                }
            },
            onDismiss = { showCaptureDialog = false }
        )
    }

    // 4. Gerenciamento do Layout com base na API
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
                modifier = Modifier.fillMaxSize().background(Brush.verticalGradient(listOf(ThemeColors.topBackground, ThemeColors.bottomBackground))).padding(24.dp),
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

            // Transformamos o DTO da API na sua classe Pokemon antiga para aproveitar seus Cards!
            val mappedPokemon = Pokemon(
                id = detailsDto.id,
                name = detailsDto.name,
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${detailsDto.id}.png",

                // 1. Pegando a lista de tipos e extraindo os nomes!
                types = detailsDto.types.map { it.type.name },

                height = detailsDto.height.toDouble() / 10.0,
                weight = detailsDto.weight.toDouble() / 10.0,

                // 2. Pegando as habilidades
                abilities = detailsDto.abilities.map { it.ability.name.replace("-", " ") },

                // 3. Pegando os atributos e convertendo para sua classe Stat
                stats = detailsDto.stats.map {
                    com.example.pokedex.data.Stat(name = it.stat.name, value = it.base_stat)
                },

                // 4. Inserindo dados dinâmicos da API (Descricao, Fraquezas, Genero e Evolucoes)
                description = fullDetails.description,
                weaknesses = fullDetails.weaknesses,
                gender = fullDetails.gender,
                evolutions = fullDetails.evolutions
            )

            // Seu Layout Original Impecável!
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
                    // Quando clicar para adicionar ao time, exibimos o Dialog em vez de adicionar direto!
                    onAddToTeamClick = { showCaptureDialog = true },
                    onViewTeamClick = { onViewTeamClick() },
                    isInTeam = isInTeam
                )

                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}
