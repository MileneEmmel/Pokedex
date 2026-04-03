package com.example.pokedex

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.toRoute
import com.example.pokedex.data.Pokemon
import com.example.pokedex.data.PokemonMock
import com.example.pokedex.navigation.HomeRoute
import com.example.pokedex.navigation.MyTeamRoute
import com.example.pokedex.navigation.PokedexRoute
import com.example.pokedex.navigation.PokemonDetailRoute
import com.example.pokedex.ui.HomeScreen
import com.example.pokedex.ui.pokedex.PokedexGridScreen
import com.example.pokedex.ui.PokemonDetailScreen
import com.example.pokedex.ui.capitalizePokemonName
import com.example.pokedex.ui.scaffold.GlassBottomNav
import com.example.pokedex.ui.scaffold.GlassTopBar
import com.example.pokedex.ui.team.TeamBuilderScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = backStackEntry?.destination
        val currentPokemon = backStackEntry
            ?.takeIf { currentDestination?.hasRoute<PokemonDetailRoute>() == true }
            ?.toRoute<PokemonDetailRoute>()
            ?.let { PokemonMock.findById(it.pokemonId) }

        val visualTeam = remember {
            mutableStateListOf<Pokemon>().apply {
                // Para testar com 3 Pokémons, descomente:
                // addAll(PokemonMock.pokedex.take(3))
            }
        }

        val title = when {
            currentDestination?.hasRoute<HomeRoute>() == true -> "POKÉDEX"
            currentDestination?.hasRoute<PokedexRoute>() == true -> "POKÉDEX"
            currentDestination?.hasRoute<MyTeamRoute>() == true -> "MY TEAM"
            currentDestination?.hasRoute<PokemonDetailRoute>() == true -> {
                currentPokemon?.name?.capitalizePokemonName() ?: "Pokémon Details"
            }
            else -> "POKÉDEX"
        }

        val showBottomBar =
            currentDestination?.hasRoute<PokedexRoute>() == true ||
                    currentDestination?.hasRoute<MyTeamRoute>() == true

        Scaffold(
            topBar = {
                GlassTopBar(
                    title = title,
                )
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
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = HomeRoute,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable<HomeRoute> {
                    HomeScreen(
                        onSeePokedexClick = {
                            navController.navigate(PokedexRoute)
                        },
                        onSeeTeamClick = {
                            navController.navigate(MyTeamRoute)
                        }
                    )
                }

                composable<PokedexRoute> {
                    PokedexGridScreen(
                        pokemons = PokemonMock.pokedex,
                        onPokemonClick = { pokemonId ->
                            navController.navigate(PokemonDetailRoute(pokemonId))
                        },
                    )
                }

                composable<MyTeamRoute> {
                    TeamBuilderScreen(
                        team = visualTeam,
                        modifier = Modifier,
                        onExploreClick = {
                            navController.navigate(PokedexRoute) {
                                 popUpTo(PokedexRoute) { inclusive = true }
                            }
                        }
                    )
                }

                composable<PokemonDetailRoute> { backStackEntry ->
                    val route = backStackEntry.toRoute<PokemonDetailRoute>()
                    val pokemon = PokemonMock.findById(route.pokemonId)

                    PokemonDetailScreen(
                        pokemon = pokemon,
                        onBackClick = {
                            navController.popBackStack()
                        }
                    )
                }
            }

        }
    }
}