package com.example.pokedex.data

data class PokemonStat(
    val name: String,
    val value: Int
)

data class Pokemon(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val types: List<String>,
    val height: Double,           // Metros
    val weight: Double,           // Quilogramas
    val abilities: List<String>,  // Lista de habilidades
    val gender: String,
    val weaknesses: List<String>, // Lista de fraquezas
    val evolutions: List<String>, // Ciclo completo de evoluções
    val stats: List<PokemonStat>,
    val description: String
)