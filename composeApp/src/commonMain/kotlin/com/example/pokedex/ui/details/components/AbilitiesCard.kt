package com.example.pokedex.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FlashOn
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.capitalizePokemonName
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AbilitiesCard(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(2.dp, Color.White, RoundedCornerShape(24.dp)) // Borda branca adicionada
            .background(Color(0xFFFBFBFB), RoundedCornerShape(24.dp))
            .padding(16.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            // Título
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.FlashOn,
                    contentDescription = null,
                    tint = Color(0xFF2D6A4F),
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "ABILITIES",
                    color    = Color(0xFF2D6A4F),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
                )
            }

            // Habilidades
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                pokemon.abilities.forEach { ability ->
                    Box(
                        modifier = Modifier
                            .shadow(4.dp, RoundedCornerShape(16.dp))
                            .background(Color(0xFF059669), RoundedCornerShape(16.dp)) // Verde mais azulado/teal
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = ability.capitalizePokemonName(),
                            color = Color.White,
                            fontSize = 11.sp,
                            fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
                        )
                    }
                }
            }
        }
    }
}