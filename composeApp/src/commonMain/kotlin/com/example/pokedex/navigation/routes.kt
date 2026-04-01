package com.example.pokedex.navigation

import kotlinx.serialization.Serializable

    @kotlinx.serialization.Serializable
    object HomeRoute

    @kotlinx.serialization.Serializable
    object PokedexRoute

    @Serializable
    data class PokemonDetailRoute(val pokemonId: Int)
