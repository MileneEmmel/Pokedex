package com.example.pokedex.ui.team

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
import androidx.compose.ui.unit.sp
import com.example.pokedex.ui.HomeTypography
import com.example.pokedex.ui.HomeStyleTokens

@Composable
fun TeamStatusCard(
    teamSize: Int,
    avgHp: Int,
    avgAtk: Int,
    avgDef: Int,
    avgSpd: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.White.copy(alpha = 0.35f),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // Team Size Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF399C55), RoundedCornerShape(18.dp))
                    .border(
                        width = 1.dp,
                        color = Color(0xFF1B5E20),
                        shape = RoundedCornerShape(18.dp)
                    )
                    .padding(vertical = 12.dp, horizontal = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Team Size",
                        color = Color.White.copy(alpha = 0.92f),
                        style = MaterialTheme.typography.bodySmall
                    )
                    Text(
                        text = "$teamSize/6",
                        color = HomeStyleTokens.neonGreen,
                        style = HomeTypography.statValue(),
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }

            // AVG STATS Label
            Text(
                text = "AVG STATS",
                color = Color(0xFF1B5E20),
                style = HomeTypography.statValue(),
                fontWeight = FontWeight.ExtraBold,
                fontSize = 14.sp,
                modifier = Modifier.padding(horizontal = 4.dp)
            )

            // AVG Stats Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF399C55), RoundedCornerShape(18.dp))
                    .border(
                        width = 1.dp,
                        color = Color(0xFF1B5E20),
                        shape = RoundedCornerShape(18.dp)
                    )
                    .padding(vertical = 12.dp, horizontal = 8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    StatItem(avgHp, "HP", HomeStyleTokens.neonRed)
                    StatItem(avgAtk, "ATK", HomeStyleTokens.neonOrange)
                    StatItem(avgDef, "DEF", HomeStyleTokens.neonYellow)
                    StatItem(avgSpd, "SPD", HomeStyleTokens.neonPurple)
                }
            }
        }
    }
}

@Composable
fun StatItem(value: Int, label: String, valueColor: Color) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value.toString(),
            color = valueColor,
            style = HomeTypography.statValue(),
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = label,
            color = Color.White.copy(alpha = 0.92f),
            style = MaterialTheme.typography.bodySmall
        )
    }
}


