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
        "hp" -> ThemeColors.neonRed
        "attack", "atk" -> ThemeColors.neonOrange
        "defense", "def" -> ThemeColors.neonYellow
        "special-attack", "sp-attack", "sp.atk" -> ThemeColors.neonBlue
        "special-defense", "sp-defense", "sp.def" -> ThemeColors.neonGreen
        "speed", "spd" -> ThemeColors.neonPurple
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

@Composable
fun MiniStat(label: String, value: Int, valueColor: Color, bgColor: Color, borderColor: Color) {
    ElevatedCard(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = bgColor),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
        modifier = Modifier.border(1.dp, borderColor, RoundedCornerShape(8.dp))
    ) {
        Column(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 2.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = value.toString(),
                color = valueColor,
                style = Typography.statValue(),
                fontSize = 13.sp,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = label,
                color = Color(0xFF14532D).copy(alpha = 0.8f),
                style = MaterialTheme.typography.labelSmall,
                fontSize = 9.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun StatItem(value: Int, label: String, valueColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value.toString(),
            color = valueColor,
            style = Typography.statValue(),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 20.sp
        )
        Text(
            text = label,
            color = Color.White.copy(alpha = 0.80f),
            style = MaterialTheme.typography.bodySmall,
            fontSize = 10.sp
        )
    }
}