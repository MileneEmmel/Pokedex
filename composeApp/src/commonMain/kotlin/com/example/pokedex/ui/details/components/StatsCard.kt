package com.example.pokedex.ui.details.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.AppFonts
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.getStatColor
import com.example.pokedex.ui.getMaxStatValue

@Composable
fun StatsCard(pokemon: Pokemon, modifier: Modifier = Modifier) {
    val shape = RoundedCornerShape(24.dp)

    ElevatedCard(
        modifier = modifier.fillMaxWidth().border(1.dp, Color.White, shape),
        shape = shape,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = ThemeColors.lightIceGreen
        )
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {

            Text(
                text = "STATS",
                color = ThemeColors.deepGreen,
                fontSize = 12.sp,
                fontFamily = AppFonts.pixel()
            )

            pokemon.stats.forEach { stat -> StatRow(stat.name, stat.value) }
        }
    }
}

@Composable
fun StatRow(statName: String, statValue: Int) {
    val statColor = getStatColor(statName)

    val fullName = statName.split("-").joinToString(" ") {
        it.replaceFirstChar { char -> char.uppercase() }
    }

    val maxStatValue = getMaxStatValue(statName)

    var animationPlayed by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) { animationPlayed = true }

    val fraction = (statValue / maxStatValue).coerceIn(0f, 1f)

    val animatedFraction by animateFloatAsState(
        targetValue = if (animationPlayed) fraction else 0f,
        animationSpec = tween(900)
    )

    val shape = RoundedCornerShape(6.dp)

    // Gradiente (50% -> 100%)
    val gradient = Brush.horizontalGradient(
        colors = listOf(statColor.copy(alpha = 0.5f), statColor)
    )

    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = fullName,
                color = ThemeColors.deepGreen,
                fontSize = 10.sp,
                fontFamily = AppFonts.pixel()
            )

            Text(
                text = statValue.toString(),
                color = ThemeColors.deepGreen,
                fontSize = 10.sp,
                fontFamily = AppFonts.pixel()
            )
        }

        // Track
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .background(ThemeColors.iceGreen, shape)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth(animatedFraction)
                    .fillMaxHeight()
                    .background(gradient, shape)
            )
        }
    }
}

