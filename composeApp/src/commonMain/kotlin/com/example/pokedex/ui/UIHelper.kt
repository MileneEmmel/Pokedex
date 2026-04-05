package com.example.pokedex.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun String.capitalizePokemonName(): String =
    replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }

fun Int.formatPokemonNumber(): String = "#${toString().padStart(3, '0')}"

fun getTypeColor(type: String): Color {
    return when (type.lowercase()) {
        "bug"      -> ThemeColors.typeBug
        "dragon"   -> ThemeColors.typeDragon
        "electric" -> ThemeColors.typeElectric
        "fairy"    -> ThemeColors.typeFairy
        "fighting" -> ThemeColors.typeFighting
        "fire"     -> ThemeColors.typeFire
        "flying"   -> ThemeColors.typeFlying
        "ghost"    -> ThemeColors.typeGhost
        "grass"    -> ThemeColors.typeGrass
        "ground"   -> ThemeColors.typeGround
        "ice"      -> ThemeColors.typeIce
        "normal"   -> ThemeColors.typeNormal
        "poison"   -> ThemeColors.typePoison
        "psychic"  -> ThemeColors.typePsychic
        "rock"     -> ThemeColors.typeRock
        "steel"    -> ThemeColors.typeSteel
        "water"    -> ThemeColors.typeWater
        else       -> Color.LightGray
    }
}

fun getStatColor(statName: String): Color {
    return when (statName.lowercase()) {
        "hp" -> ThemeColors.neonRed
        "attack", "atk" -> ThemeColors.neonOrange
        "defense", "def" -> ThemeColors.neonYellow
        "special-attack", "sp-attack", "sp.atk" -> ThemeColors.neonBlue
        "special-defense", "sp-defense", "sp.def" -> ThemeColors.neonGreen
        "speed", "spd" -> ThemeColors.neonPurple
        else -> Color.Gray
    }
}

