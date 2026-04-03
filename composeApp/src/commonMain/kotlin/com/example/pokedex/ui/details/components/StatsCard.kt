package com.example.pokedex.ui.details.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.getStatColor
import com.example.pokedex.ui.getMaxStatValue
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

@Composable
fun StatsCard(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(2.dp, Color.White, RoundedCornerShape(24.dp))
            .background(Color(0xFFFBFBFB), RoundedCornerShape(24.dp))
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "STATS",
                color = Color(0xFF2D6A4F),
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
            )

            // Lista os stats
            pokemon.stats.forEach { stat ->
                StatRow(statName = stat.name, statValue = stat.value)
            }
        }
    }
}

@Composable
fun StatRow(statName: String, statValue: Int) {
    // Busca a cor correta baseada no nome
    val statColor = getStatColor(statName)

    // Formata o nome completo substituindo hifens e capitalizando
    val fullName = statName.split("-").joinToString(" ") {
        it.replaceFirstChar { char -> char.uppercase() }
    }

    // Busca o valor máximo real desse status na Pokédex
    val maxStatValue = getMaxStatValue(statName)

    // Animação suave para a barra encher
    var animationPlayed by remember { mutableStateOf(false) }
    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    val fraction = (statValue / maxStatValue).coerceIn(0f, 1f)

    val animatedFraction by animateFloatAsState(
        targetValue = if (animationPlayed) fraction else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    // Gradiente que aumenta a intensidade da cor conforme preenche
    val barGradient = Brush.horizontalGradient(
        colors = listOf(
            statColor.copy(alpha = 0.5f), // Começa mais transparente
            statColor                     // Termina na cor sólida
        )
    )

    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = fullName,
                color = Color(0xFF2D6A4F),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
            )
            Text(
                text = statValue.toString(),
                color = Color(0xFF2D6A4F),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
            )
        }

        // Fundo cinza/transparente da barra de progresso
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .background(Color(0xFFDDECDD), RoundedCornerShape(6.dp))
        ) {
            // Barra colorida preenchida animada com gradiente
            Box(
                modifier = Modifier
                    .fillMaxWidth(animatedFraction)
                    .fillMaxHeight()
                    .background(barGradient, RoundedCornerShape(6.dp))
            )
        }
    }
}

