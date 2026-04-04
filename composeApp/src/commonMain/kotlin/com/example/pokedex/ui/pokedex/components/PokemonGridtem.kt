package com.example.pokedex.ui.pokedex.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.capitalizePokemonName
import com.example.pokedex.ui.formatPokemonNumber
import com.example.pokedex.ui.getTypeColor
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

@Composable
fun PokemonGridItem(pokemon: Pokemon, onClick: () -> Unit) {

    val shape = RoundedCornerShape(20.dp)

    ElevatedCard(
        onClick = onClick,
        shape = shape,
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, Color.White, shape)
    ) {
        Column {

            // PARTE SUPERIOR
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .background(ThemeColors.iceGreen)
            ) {

                Text(
                    text = pokemon.id.formatPokemonNumber(),
                    color = ThemeColors.deepGreen,
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(Res.font.press_start_2p_regular)),
                    modifier = Modifier.align(Alignment.TopCenter).padding(top = 6.dp)
                )

                AsyncImage(
                    model = pokemon.imageUrl,
                    contentDescription = pokemon.name,
                    modifier = Modifier.size(100.dp).align(Alignment.BottomCenter)
                )
            }

            // PARTE INFERIOR
            Column(
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {

                Text(
                    text = pokemon.name.capitalizePokemonName(),
                    color = ThemeColors.deepGreen,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(6.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    pokemon.types.forEach { type ->

                        val typeColor = getTypeColor(type)

                        Box(
                            modifier = Modifier
                                .background(typeColor, RoundedCornerShape(12.dp))
                                .padding(horizontal = 8.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = type.uppercase(),
                                color = Color.White,
                                fontSize = 9.sp,
                                fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
                            )
                        }
                    }
                }
            }
        }
    }
}