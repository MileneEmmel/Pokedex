package com.example.pokedex.navigation

import kotlinx.serialization.Serializable

    @kotlinx.serialization.Serializable
    object HomeRoute

    @kotlinx.serialization.Serializable
    object PokedexRoute

    @kotlinx.serialization.Serializable
    object MyTeamRoute

    @Serializable
    data class PokemonDetailRoute(val pokemonId: Int)
