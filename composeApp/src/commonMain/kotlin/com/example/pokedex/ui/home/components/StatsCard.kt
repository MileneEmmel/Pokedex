package com.example.pokedex.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun StatsCard(
    modifier: Modifier = Modifier,
    pokemonCount: String = "18",
    typesCount: String = "11",
    maxTeam: String = "6"
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color(0xFF16A34A).copy(alpha = 0.72f),
                shape = RoundedCornerShape(32.dp)
            )
            .border(
                width = 2.dp,
                color = Color(0xFF227643).copy(alpha = 0.50f),
                shape = RoundedCornerShape(32.dp)
            )
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            StatItem(value = pokemonCount, label = "Pokémon", valueColor = ThemeColors.neonGreen)
            StatItem(value = typesCount, label = "Types", valueColor = ThemeColors.neonYellow)
            StatItem(value = maxTeam, label = "Max Team", valueColor = ThemeColors.neonCyan)
        }
    }
}

@Composable
private fun StatItem(value: String, label: String, valueColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val statStyle = Typography.statValue()

        Text(
            text = value,
            color = valueColor,
            style = statStyle,
            fontWeight = FontWeight.ExtraBold,
            lineHeight = statStyle.fontSize
        )
        Text(
            text = label,
            color = Color.White.copy(alpha = 0.92f),
            style = MaterialTheme.typography.bodySmall
        )
    }
}





