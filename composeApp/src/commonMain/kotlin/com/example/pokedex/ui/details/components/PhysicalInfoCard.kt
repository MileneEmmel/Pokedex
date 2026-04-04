package com.example.pokedex.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
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
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.parseGenderString
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

@Composable
fun PhysicalInfoCard(pokemon: Pokemon, modifier: Modifier = Modifier) {
    val (maleRatio, femaleRatio) = remember(pokemon.gender) {
        parseGenderString(pokemon.gender)
    }

    val shape = RoundedCornerShape(24.dp)

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, Color.White, shape),
        shape = shape,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = ThemeColors.lightIceGreen
        )
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // HEIGHT + WEIGHT
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                InfoItem(
                    title = "HEIGHT",
                    value = "${pokemon.height} m",
                    modifier = Modifier.weight(1f)
                )

                InfoItem(
                    title = "WEIGHT",
                    value = "${pokemon.weight} kg",
                    modifier = Modifier.weight(1f)
                )
            }

            // GENDER
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

                Text(
                    text = "GENDER RATIO",
                    color = ThemeColors.deepGreen,
                    fontSize = 12.sp,
                    fontFamily = pixelFont()
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(0.5.dp, Color.White, RoundedCornerShape(12.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    if (maleRatio > 0f) {
                        Box(
                            modifier = Modifier
                                .weight(maleRatio)
                                .fillMaxHeight()
                                .background(ThemeColors.lightBlue),
                            contentAlignment = Alignment.Center
                        ) {
                            if (maleRatio >= 20f) {
                                Text(
                                    text = "♂ ${maleRatio.toInt()}%",
                                    color = ThemeColors.deepGreen,
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
                                .background(ThemeColors.pink),
                            contentAlignment = Alignment.Center
                        ) {
                            if (femaleRatio >= 20f) {
                                Text(
                                    text = "♀ ${femaleRatio.toInt()}%",
                                    color = ThemeColors.deepGreen,
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
                                .background(Color.Gray),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "GENDERLESS",
                                color = ThemeColors.lightIceGreen,
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

@Composable
private fun InfoItem(
    title: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            color = ThemeColors.deepGreen,
            fontSize = 12.sp,
            fontFamily = pixelFont()
        )
        Text(
            text = value,
            color = ThemeColors.deepGreen,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Composable
private fun pixelFont(): FontFamily =
    FontFamily(Font(Res.font.press_start_2p_regular))