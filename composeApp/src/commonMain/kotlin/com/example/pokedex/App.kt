package com.example.pokedex

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.pokedex.data.PokemonMock
import com.example.pokedex.navigation.HomeRoute
import com.example.pokedex.navigation.PokedexRoute
import com.example.pokedex.navigation.PokemonDetailRoute
import com.example.pokedex.ui.HomeScreen
import com.example.pokedex.ui.PokedexGridScreen
import com.example.pokedex.ui.PokemonDetailScreen

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = HomeRoute
        ){
            composable<HomeRoute> {
                HomeScreen (
                    onSeePokedexClick = {
                        navController.navigate(PokedexRoute)
                    }
                )
            }

            composable<PokedexRoute> {
                PokedexGridScreen(
                    pokemons = PokemonMock.pokedex,
                    onPokemonClick = { pokemonId ->
                        navController.navigate(PokemonDetailRoute(pokemonId))
                    },
                    onBackClick = {
                        navController.popBackStack()
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