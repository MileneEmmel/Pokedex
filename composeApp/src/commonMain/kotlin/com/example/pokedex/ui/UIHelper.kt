package com.example.pokedex.ui

import androidx.compose.ui.graphics.Color

fun String.capitalizePokemonName(): String =
    replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }

fun Int.formatPokemonNumber(): String = "#${toString().padStart(3, '0')}"

fun getTypeDetailsColor(type: String): Color {
    return when (type.lowercase()) {
        "grass" -> Color(0xFF38E54D)
        "poison" -> Color(0xFFA020F0)
        "fire" -> Color(0xFFFF5722)
        "water" -> Color(0xFF29B6F6)
        "electric" -> Color(0xFFFFEB3B)
        "psychic" -> Color(0xFFFF4081)
        "bug" -> Color(0xFFA2C11C)
        "normal" -> Color(0xFFA8A878)
        else -> Color(0xFFBDBDBD)
    }
}

fun parseGenderString(gender: String): Pair<Float, Float> {
    if (gender.contains("genderless", ignoreCase = true)) {
        return Pair(0f, 0f)
    }

    var male = 0f
    var female = 0f

    val parts = gender.split(",")
    for (part in parts) {
        val p = part.trim()
        if (p.endsWith("M", ignoreCase = true)) {
            male = p.replace("%", "").replace("M", "", ignoreCase = true).trim().toFloatOrNull() ?: 0f
        } else if (p.endsWith("F", ignoreCase = true)) {
            female = p.replace("%", "").replace("F", "", ignoreCase = true).trim().toFloatOrNull() ?: 0f
        }
    }

    return Pair(male, female)
}

fun getStatAbbreviation(statName: String): String {
    return when (statName.lowercase()) {
        "hp" -> "HP"
        "attack", "atk" -> "ATK"
        "defense", "def" -> "DEF"
        "special-attack", "sp-attack", "sp.atk" -> "SP.ATK"
        "special-defense", "sp-defense", "sp.def" -> "SP.DEF"
        "speed", "spd" -> "SPD"
        else -> statName.uppercase()
    }
}

fun getStatColor(statName: String): Color {
    return when (statName.lowercase()) {
        "hp" -> HomeStyleTokens.neonRed
        "attack", "atk" -> HomeStyleTokens.neonOrange
        "defense", "def" -> HomeStyleTokens.neonYellow
        "special-attack", "sp-attack", "sp.atk" -> HomeStyleTokens.neonBlue
        "special-defense", "sp-defense", "sp.def" -> HomeStyleTokens.neonGreen
        "speed", "spd" -> HomeStyleTokens.neonPurple
        else -> Color.Gray
    }
}

// Função auxiliar para descobrir o teto de cada status com base no PokemonMock
fun getMaxStatValue(statName: String): Float {
    return when (statName.lowercase()) {
        "hp" -> 250f              // Chansey
        "attack" -> 134f          // Dragonite
        "defense" -> 180f         // Cloyster
        "special-attack" -> 154f  // Mewtwo
        "special-defense" -> 125f // Articuno
        "speed" -> 150f           // Electrode
        else -> 255f
    }
}