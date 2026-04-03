package com.example.pokedex.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.parseGenderString
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

@Composable
fun PhysicalInfoCard(
    pokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    val (maleRatio, femaleRatio) = remember(pokemon.gender) {
        parseGenderString(pokemon.gender)
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(2.dp, Color.White, RoundedCornerShape(24.dp)) // Borda branca adicionada
            .background(Color(0xFFFBFBFB), RoundedCornerShape(24.dp))
            .padding(16.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "HEIGHT",
                        color = Color(0xFF2D6A4F),
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
                    )
                    Text(
                        text = "${pokemon.height} m",
                        color = Color(0xFF1B4332),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Text(
                        text = "WEIGHT",
                        color = Color(0xFF2D6A4F),
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
                    )
                    Text(
                        text = "${pokemon.weight} kg",
                        color = Color(0xFF1B4332),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Text(
                    text = "GENDER RATIO",
                    color = Color(0xFF2D6A4F),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (maleRatio > 0f) {
                        Box(
                            modifier = Modifier
                                .weight(maleRatio)
                                .fillMaxHeight()
                                .background(Color(0xFF2979FF)),
                            contentAlignment = Alignment.Center
                        ) {
                            if (maleRatio >= 20f) {
                                Text(
                                    text = "♂ ${maleRatio.toInt()}%",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }

                    if (femaleRatio > 0f) {
                        Box(
                            modifier = Modifier
                                .weight(femaleRatio)
                                .fillMaxHeight()
                                .background(Color(0xFFFF4081)),
                            contentAlignment = Alignment.Center
                        ) {
                            if (femaleRatio >= 20f) {
                                Text(
                                    text = "♀ ${femaleRatio.toInt()}%",
                                    color = Color.White,
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }

                    if (maleRatio == 0f && femaleRatio == 0f) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(Color(0xFFBDBDBD)),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "GENDERLESS",
                                color = Color.White,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}