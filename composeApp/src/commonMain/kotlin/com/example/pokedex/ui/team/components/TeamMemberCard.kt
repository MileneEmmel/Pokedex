package com.example.pokedex.ui.team

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.capitalizePokemonName
import com.example.pokedex.ui.formatPokemonNumber
import com.example.pokedex.ui.HomeTypography

@Composable
fun TeamMemberCard(
    pokemon: Pokemon,
    panelColor: Color,
    panelBorder: Color,
    titleColor: Color,
    subtitleColor: Color,
    chipBackground: Color,
    chipTextColor: Color,
    accentColor: Color,
    modifier: Modifier = Modifier
) {
    ElevatedCard(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White.copy(alpha = 0.30f)),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
        modifier = modifier
            .fillMaxWidth()
            .border(3.dp, Color.White.copy(alpha = 0.50f), RoundedCornerShape(24.dp))
    ) {
        Box {
            // Decorative element
            Box(
                modifier = Modifier
                    .offset(x = 12.dp, y = 12.dp)
                    .shadow(8.dp, CircleShape, ambientColor = Color(0xFF76FF03), spotColor = Color(0xFF76FF03))
                    .size(12.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF76FF03))
            )

            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    // Pokemon image - compact
                    Box(
                        modifier = Modifier
                            .size(72.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(
                                Brush.linearGradient(
                                    listOf(Color(0xFFDCFCE7).copy(alpha = 0.50f), Color(0xFFA7F3D0).copy(alpha = 0.50f))
                                )
                            )
                            .border(2.dp, Color.White.copy(alpha = 0.40f), RoundedCornerShape(16.dp)),
                        contentAlignment = Alignment.Center
                    ) {
                        AsyncImage(
                            model = pokemon.imageUrl,
                            contentDescription = pokemon.name,
                            modifier = Modifier.size(56.dp)
                        )

                        // Pokemon number badge
                        Box(
                            modifier = Modifier
                                .align(Alignment.TopEnd)
                                .offset(x = 4.dp, y = (-4).dp)
                                .background(Color(0xFF14532D).copy(alpha = 0.80f), RoundedCornerShape(6.dp))
                                .border(1.dp, Color(0xFF76FF03).copy(alpha = 0.50f), RoundedCornerShape(6.dp))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = pokemon.id.formatPokemonNumber(),
                                color = Color(0xFF76FF03),
                                style = HomeTypography.statValue(),
                                fontSize = 8.sp
                            )
                        }
                    }

                    // Pokemon info
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(6.dp)
                    ) {
                        Text(
                            text = pokemon.name.capitalizePokemonName(),
                            color = Color(0xFF14532D),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Medium,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        // Types
                        Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            pokemon.types.take(2).forEach { type ->
                                Surface(
                                    shape = RoundedCornerShape(8.dp),
                                    color = Color.White.copy(alpha = 0.60f),
                                    border = androidx.compose.foundation.BorderStroke(1.dp, Color.White.copy(alpha = 0.80f))
                                ) {
                                    Text(
                                        text = type.capitalizePokemonName(),
                                        color = Color(0xFF166534),
                                        style = MaterialTheme.typography.labelSmall,
                                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Medium
                                    )
                                }
                            }
                        }

                        // Mini Stats - compact horizontal
                        Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            MiniStat(
                                label = "HP",
                                value = pokemon.stats.firstOrNull { it.name == "hp" }?.value ?: 0,
                                valueColor = Color(0xFFFF1744),
                                bgColor = Color(0xFF7F1D1D).copy(alpha = 0.30f),
                                borderColor = Color(0xFFEF4444).copy(alpha = 0.30f)
                            )
                            MiniStat(
                                label = "ATK",
                                value = pokemon.stats.firstOrNull { it.name == "attack" }?.value ?: 0,
                                valueColor = Color(0xFFFFA726),
                                bgColor = Color(0xFF7C2D12).copy(alpha = 0.30f),
                                borderColor = Color(0xFFF97316).copy(alpha = 0.30f)
                            )
                            MiniStat(
                                label = "DEF",
                                value = pokemon.stats.firstOrNull { it.name == "defense" }?.value ?: 0,
                                valueColor = Color(0xFFFFEA00),
                                bgColor = Color(0xFF713F12).copy(alpha = 0.30f),
                                borderColor = Color(0xFFFACC15).copy(alpha = 0.30f)
                            )
                        }
                    }
                }

                // View Details Link
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.horizontalGradient(
                                listOf(Color(0xFF10B981).copy(alpha = 0.80f), Color(0xFF16A34A).copy(alpha = 0.80f))
                            )
                        )
                        .border(1.dp, Color.White.copy(alpha = 0.30f))
                        .padding(vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "View Details",
                        color = Color.White,
                        style = MaterialTheme.typography.bodySmall,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}

@Composable
private fun MiniStat(label: String, value: Int, valueColor: Color, bgColor: Color, borderColor: Color) {
    Box(
        modifier = Modifier
            .background(bgColor, RoundedCornerShape(8.dp))
            .border(1.dp, borderColor, RoundedCornerShape(8.dp))
            .padding(horizontal = 6.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = value.toString(),
                color = valueColor,
                style = HomeTypography.statValue(),
                fontSize = 12.sp
            )
            Text(
                text = label,
                color = Color.White.copy(alpha = 0.70f),
                style = MaterialTheme.typography.labelSmall,
                fontSize = 10.sp
            )
        }
    }
}