package com.example.pokedex.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.capitalizePokemonName
import com.example.pokedex.ui.getTypeColor
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

@Composable
fun AbilitiesCard(pokemon: Pokemon, modifier: Modifier = Modifier) {
    val shape = RoundedCornerShape(24.dp)

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, androidx.compose.ui.graphics.Color.White, shape),
        shape = shape,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = ThemeColors.lightIceGreen
        )
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // TITLE
            Text(
                text = "ABILITIES",
                color = ThemeColors.deepGreen,
                fontSize = 12.sp,
                fontFamily = pixelFont()
            )

            // ABILITIES LIST
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                pokemon.abilities.forEach { ability ->

                    val typeColors = pokemon.types.map { getTypeColor(it) }

                    val backgroundModifier = when (typeColors.size) {
                        0 -> Modifier.background(
                            color = ThemeColors.darkGreen,
                            shape = RoundedCornerShape(16.dp)
                        )

                        1 -> Modifier.background(
                            color = typeColors.first(),
                            shape = RoundedCornerShape(16.dp)
                        )

                        else -> Modifier.background(
                            brush = Brush.horizontalGradient(
                                listOf(typeColors[0], typeColors[1])
                            ),
                            shape = RoundedCornerShape(16.dp)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .then(backgroundModifier)
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = ability.capitalizePokemonName(),
                            color = ThemeColors.lightIceGreen,
                            fontSize = 11.sp,
                            fontFamily = pixelFont()
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun pixelFont(): FontFamily =
    FontFamily(Font(Res.font.press_start_2p_regular))