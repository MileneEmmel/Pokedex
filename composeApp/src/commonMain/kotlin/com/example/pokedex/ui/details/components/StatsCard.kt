package com.example.pokedex.ui.details.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.Typography
import com.example.pokedex.ui.getStatColor
import com.example.pokedex.ui.getMaxStatValue

@Composable
fun StatsCard(pokemon: Pokemon, modifier: Modifier = Modifier) {
    val shape = RoundedCornerShape(24.dp)

    ElevatedCard(
        modifier  = modifier.fillMaxWidth().border(1.dp, Color.White, shape),
        shape     = shape,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        colors    = CardDefaults.elevatedCardColors(containerColor = ThemeColors.lightIceGreen)
    ) {
        Column(
            modifier            = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            Row(
                verticalAlignment     = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon( // Ícone
                    imageVector        = Icons.Default.Bolt,
                    contentDescription = null,
                    tint               = ThemeColors.deepGreen,
                    modifier           = Modifier.size(20.dp)
                )

                Text( // Título
                    text  = "STATS",
                    color = ThemeColors.deepGreen,
                    style = Typography.pixelCardTitle()
                )
            }

            // Renderiza uma linha para cada atributo do Pokémon
            pokemon.stats.forEach { stat -> StatRow(stat.name, stat.value) }
        }
    }
}

@Composable
fun StatRow(statName: String, statValue: Int) {
    // Cor correspondente para cada atributo
    val statColor = getStatColor(statName)

    // Nome completo do atributo
    val fullName = statName.split("-").joinToString(" ") {
        it.replaceFirstChar { char -> char.uppercase() }
    }

    // Pega o valor máximo do atributo
    val maxStatValue = getMaxStatValue(statName)

    var animationPlayed by remember { mutableStateOf(false) }

    // Dispara a animação assim que o componente entra na tela
    LaunchedEffect(Unit) { animationPlayed = true }

    // Calcula a fração preenchida da barra
    val fraction = (statValue / maxStatValue).coerceIn(0f, 1f)

    // Animação de preenchimento das barras de atributos
    val animatedFraction by animateFloatAsState(
        targetValue   = if (animationPlayed) fraction else 0f,
        animationSpec = tween(900)
    )

    val shape = RoundedCornerShape(6.dp)

    // Gradiente de preenchimento da barra de atributo
    val gradient = Brush.horizontalGradient(
        colors = listOf(statColor.copy(alpha = 0.5f), statColor)
    )

    Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        Row(
            modifier              = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment     = Alignment.CenterVertically
        ) {
            Text( // Nome
                text  = fullName,
                color = ThemeColors.deepGreen,
                style = Typography.pixelId()
            )

            Text( // Valor
                text  = statValue.toString(),
                color = ThemeColors.deepGreen,
                style = Typography.pixelId()
            )
        }

        // Barra de progresso
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(12.dp)
                .background(ThemeColors.iceGreen, shape)
                .border(0.5.dp, Color.White, shape)
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