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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
import com.example.pokedex.ui.Typography
import com.example.pokedex.ui.ThemeColors
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
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 3.dp,
                color = ThemeColors.white.copy(alpha = 0.50f),
                shape = RoundedCornerShape(24.dp)
            ),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = ThemeColors.white.copy(alpha = 0.30f)),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // TEAM SIZE
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(ThemeColors.greenPrimary.copy(alpha = 0.7f),
                        shape = RoundedCornerShape(32.dp)
                    )
                    .border(
                        width = 2.dp,
                        color = ThemeColors.mediumGreen,
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
                        color = ThemeColors.white,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = "$teamSize/6",
                        color = ThemeColors.neonGreen,
                        style = Typography.statValue(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                }
            }

            // AVG STATS
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(horizontal = 4.dp)
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.trending_up),
                        contentDescription = "Trending Up",
                        tint = ThemeColors.greenPrimary,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "AVG STATS",
                        color = ThemeColors.deepGreen,
                        style = Typography.statValue(),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 16.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(ThemeColors.greenPrimary.copy(alpha = 0.7f),
                            shape = RoundedCornerShape(32.dp)
                        )
                        .border(
                            width = 2.dp,
                            color = ThemeColors.mediumGreen,
                            shape = RoundedCornerShape(32.dp)
                        )
                        .padding(start = 12.dp, end = 12.dp, top = 16.dp, bottom = 8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        StatItem(avgHp, "HP", ThemeColors.neonRed)
                        StatItem(avgAtk, "ATK", ThemeColors.neonOrange)
                        StatItem(avgDef, "DEF", ThemeColors.neonYellow)
                        StatItem(avgSpd, "SPD", ThemeColors.neonPurple)
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