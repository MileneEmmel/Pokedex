package com.example.pokedex.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.AppFonts
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.getTypeColor

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WeaknessesCard(
    pokemon: Pokemon,
    modifier: Modifier = Modifier
) {
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

            // TITLE
            Text(
                text = "WEAKNESSES",
                color = ThemeColors.deepGreen,
                fontSize = 12.sp,
                fontFamily = AppFonts.pixel()
            )

            // TYPES
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                pokemon.weaknesses.forEach { weakness ->

                    val typeColor = getTypeColor(weakness)

                    Box(
                        modifier = Modifier
                            .border(
                                width = 0.5.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(16.dp)
                            )
                            .background(typeColor, RoundedCornerShape(16.dp))
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = weakness.uppercase(),
                            color = Color.White,
                            fontSize = 10.sp,
                            fontFamily = AppFonts.pixel()
                        )
                    }
                }
            }
        }
    }
}

