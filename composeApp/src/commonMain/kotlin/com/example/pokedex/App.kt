package com.example.pokedex

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.toRoute
import androidx.room.RoomDatabase
import com.example.pokedex.data.Pokemon
import com.example.pokedex.data.local.AppDatabase
import com.example.pokedex.data.remote.KtorPokeApi
import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.navigation.HomeRoute
import com.example.pokedex.navigation.MyTeamRoute
import com.example.pokedex.navigation.PokedexRoute
import com.example.pokedex.navigation.PokemonDetailRoute
import com.example.pokedex.ui.UiState
import com.example.pokedex.ui.capitalizePokemonName
import com.example.pokedex.ui.details.PokemonDetailScreen
import com.example.pokedex.ui.details.PokemonDetailViewModel
import com.example.pokedex.ui.home.HomeScreen
import com.example.pokedex.ui.pokedex.PokedexGridScreen
import com.example.pokedex.ui.pokedex.PokedexViewModel
import com.example.pokedex.ui.scaffold.GlassBottomNav
import com.example.pokedex.ui.scaffold.GlassTopBar
import com.example.pokedex.ui.team.TeamBuilderScreen
import com.example.pokedex.ui.team.TeamViewModel

@Composable
fun App(
    databaseBuilder: RoomDatabase.Builder<AppDatabase> // Recebemos o Banco aqui!
) {
    MaterialTheme {
        val maxTeamSize = 6
        val navController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = backStackEntry?.destination

        // =========================================================
        // 1. INJEÇÃO DE DEPENDÊNCIAS (Rodam apenas 1x ao abrir o app)
        // =========================================================
        val database = remember { databaseBuilder.build() }
        val api = remember { KtorPokeApi() }
        val repository = remember { PokemonRepository(api, database.pokemonDao()) }

        // =========================================================
        // 2. VIEWMODELS OFICIAIS (Gerenciam as telas)
        // =========================================================
        val pokedexViewModel = remember { PokedexViewModel(repository) }
        val detailViewModel = remember { PokemonDetailViewModel(repository) }
        val teamViewModel = remember { TeamViewModel(repository) }

        var showTeamFullAlert by remember { mutableStateOf(false) }

        // Mantém o time sincronizado globalmente com o Banco de Dados
        LaunchedEffect(Unit) {
            teamViewModel.loadTeam()
        }
        val teamEntities by teamViewModel.teamState.collectAsState()

        // Lógica do Título Dinâmico (Agora busca do ViewModel de Detalhes!)
        val title = when {
            currentDestination?.hasRoute<HomeRoute>() == true -> "POKÉDEX"
            currentDestination?.hasRoute<PokedexRoute>() == true -> "POKÉDEX"
            currentDestination?.hasRoute<MyTeamRoute>() == true -> "MY TEAM"
            currentDestination?.hasRoute<PokemonDetailRoute>() == true -> {
                val state by detailViewModel.detailState.collectAsState()
                val currentState = state
                if (currentState is UiState.Success) currentState.data.dto.name.capitalizePokemonName() else "Detalhes"
            }
            else -> "POKÉDEX"
        }

        val showBottomBar =
            currentDestination?.hasRoute<PokedexRoute>() == true ||
                    currentDestination?.hasRoute<MyTeamRoute>() == true

        val showTopBar = currentDestination?.hasRoute<HomeRoute>() != true

        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                if (showTopBar) {
                    GlassTopBar(
                        title = title,
                        showBack = currentDestination?.hasRoute<PokemonDetailRoute>() == true,
                        onBackClick = { navController.popBackStack() }
                    )
                }
            },
            bottomBar = {
                if (showBottomBar) {
                    currentDestination.let { destination ->
                        GlassBottomNav(
                            isPokedexSelected = destination.hasRoute<PokedexRoute>(),
                            isTeamSelected = destination.hasRoute<MyTeamRoute>(),
                            onPokedexClick = { navController.navigate(PokedexRoute) },
                            onTeamClick = { navController.navigate(MyTeamRoute) }
                        )
                    }
                }
            }
        ) { _ ->
            NavHost(
                navController = navController,
                startDestination = HomeRoute,
                modifier = Modifier.fillMaxSize()
            ) {

                // ROTA: HOME
                composable<HomeRoute> {
                    HomeScreen(
                        onSeePokedexClick = { navController.navigate(PokedexRoute) },
                        onSeeTeamClick = { navController.navigate(MyTeamRoute) }
                    )
                }

                // ROTA: POKEDEX
                composable<PokedexRoute> {
                    PokedexGridScreen(
                        viewModel = pokedexViewModel, // Usa o BD e Ktor!
                        onPokemonClick = { pokemonId ->
                            navController.navigate(PokemonDetailRoute(pokemonId))
                        },
                    )
                }

                // ROTA: MY TEAM
                composable<MyTeamRoute> {
                    // Recarrega do banco de dados toda vez que entra na tela do time
                    LaunchedEffect(Unit) {
                        teamViewModel.loadTeam()
                    }

                    // Transforma os dados do Banco no formato visual que os seus Cards já usam
                    val mappedTeam = teamEntities.map { favorite ->
                        Pokemon(
                            id = favorite.id,
                            name = favorite.name,
                            imageUrl = favorite.imageUrl,
                            types = favorite.types.split(","),
                            height = 0.0,
                            weight = 0.0,
                            abilities = emptyList(),
                            gender = "",
                            weaknesses = emptyList(),
                            evolutions = emptyList(),
                            stats = listOf(
                                com.example.pokedex.data.Stat("hp", favorite.hp),
                                com.example.pokedex.data.Stat("attack", favorite.attack),
                                com.example.pokedex.data.Stat("defense", favorite.defense),
                                com.example.pokedex.data.Stat("speed", favorite.speed)
                            ),
                            description = "Caught at: ${favorite.captureLocation}"
                        )
                    }

                    TeamBuilderScreen(
                        team = mappedTeam,
                        modifier = Modifier,
                        onExploreClick = {
                            navController.navigate(PokedexRoute) {
                                popUpTo(PokedexRoute) { inclusive = true }
                            }
                        },
                        onViewDetailsClick = { pokemonId ->
                            navController.navigate(PokemonDetailRoute(pokemonId))
                        },
                        onRemovePokemon = { pokemonId ->
                            teamViewModel.removePokemon(pokemonId) // Remove do BD!
                        }
                    )
                }

                // ROTA: DETALHES
                composable<PokemonDetailRoute> { backStackEntry ->
                    val route = backStackEntry.toRoute<PokemonDetailRoute>()

                    // Verifica se já está no time consultando o state do banco
                    val isInTeam = teamEntities.any { it.id == route.pokemonId }

                    PokemonDetailScreen(
                        pokemonId = route.pokemonId,
                        viewModel = detailViewModel, // API de tempo real!
                        onBackClick = {
                            navController.popBackStack()
                        },
                        onViewTeamClick = {
                            navController.navigate(MyTeamRoute)
                        },
                        isInTeam = isInTeam,
                        showTeamFullAlert = showTeamFullAlert,
                        onDismissTeamFullAlert = { showTeamFullAlert = false }
                    )
                }
            }
        }
    }
}