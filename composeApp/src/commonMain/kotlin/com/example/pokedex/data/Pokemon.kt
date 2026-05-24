package com.example.pokedex.data

data class Pokemon(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val types: List<String>,
    val height: Double,
    val weight: Double,
    val abilities: List<String>,
    val gender: String,
    val weaknesses: List<String>,
    val evolutions: List<EvolutionMember>,
    val stats: List<Stat>,
    val description: String
)

data class EvolutionMember(
    val id: Int,
    val name: String,
    val imageUrl: String
)

data class Stat(
    val name: String,
    val value: Int,
    val maxValue: Int = 100
)