package com.example.pokedex.ui.team

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
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
import org.jetbrains.compose.resources.painterResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.trending_up

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
                color = Color.White.copy(alpha = 0.30f),
                shape = RoundedCornerShape(24.dp)
            )
            .border(
                width = 3.dp,
                color = Color.White.copy(alpha = 0.50f),
                shape = RoundedCornerShape(24.dp)
            )
            .padding(24.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Team Size Card - Agora mais arredondado (32.dp)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF16A34A).copy(alpha = 0.72f),
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
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Team Size",
                        color = Color.White,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "$teamSize/6",
                        color = HomeStyleTokens.neonGreen,
                        style = HomeTypography.statValue(),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 24.sp
                    )
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                // Título AVG STATS com o ícone
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.trending_up),
                        contentDescription = "Trending Up",
                        tint = Color(0xFF16A34A),
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "AVG STATS",
                            color = Color(0xFF166534),
                        style = HomeTypography.statValue(),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF16A34A).copy(alpha = 0.72f),
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
                        StatItem(avgHp, "HP", HomeStyleTokens.neonRed)
                        StatItem(avgAtk, "ATK", HomeStyleTokens.neonOrange)
                        StatItem(avgDef, "DEF", HomeStyleTokens.neonYellow)
                        StatItem(avgSpd, "SPD", HomeStyleTokens.neonPurple)
                    }
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