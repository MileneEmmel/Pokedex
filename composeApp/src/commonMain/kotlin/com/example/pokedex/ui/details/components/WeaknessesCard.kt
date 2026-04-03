package com.example.pokedex.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Shield
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
import com.example.pokedex.ui.getTypeDetailsColor
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WeaknessesCard(pokemon: Pokemon, modifier: Modifier = Modifier) {
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
                    imageVector = Icons.Outlined.Shield, // Ícone de escudo
                    contentDescription = null,
                    tint = Color(0xFF2D6A4F),
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "WEAKNESSES",
                    color    = Color(0xFF2D6A4F),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
                )
            }

            // Tipos de Fraqueza
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                pokemon.weaknesses.forEach { weakness ->
                    val typeColor = getTypeDetailsColor(weakness)

                    Box(
                        modifier = Modifier
                            .shadow(
                                elevation = 8.dp,
                                shape = RoundedCornerShape(16.dp),
                                spotColor = typeColor,
                                ambientColor = typeColor
                            )
                            .background(typeColor, RoundedCornerShape(16.dp))
                            .padding(horizontal = 12.dp, vertical = 6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = weakness.uppercase(),
                            color = Color.White,
                            fontSize = 10.sp,
                            fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
                        )
                    }
                }
            }
        }
    }
}