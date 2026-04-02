package com.example.pokedex.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Card
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
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(18.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF45C965)),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color(0xFF399C55), RoundedCornerShape(14.dp))
                .padding(vertical = 12.dp, horizontal = 8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                StatItem(value = pokemonCount, label = "Pokémon", valueColor = HomeStyleTokens.neonGreen)
                StatItem(value = typesCount, label = "Types", valueColor = HomeStyleTokens.neonYellow)
                StatItem(value = maxTeam, label = "Max Team", valueColor = HomeStyleTokens.neonCyan)
            }
        }
    }
}

@Composable
private fun StatItem(value: String, label: String, valueColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val statStyle = HomeTypography.statValue()

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





