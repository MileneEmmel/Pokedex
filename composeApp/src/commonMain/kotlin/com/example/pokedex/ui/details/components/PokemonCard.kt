package com.example.pokedex.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.capitalizePokemonName
import com.example.pokedex.ui.formatPokemonNumber
import com.example.pokedex.ui.getTypeDetailsColor
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

@Composable
fun PokemonCard(
    pokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    val cardColor = Color(0xFF16A34A)

    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(8.dp, RoundedCornerShape(24.dp))
            .border(2.dp, Color(0xFF2D6A4F), RoundedCornerShape(24.dp)) // Borda do card
            .background(cardColor, RoundedCornerShape(24.dp))
            .padding(start = 24.dp, top = 12.dp, end = 24.dp, bottom = 24.dp) // Espaçamento superior
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Lado Esquerdo: Número, Nome e Tipos
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Número do Pokémon
                Text(
                    text = pokemon.id.formatPokemonNumber(),
                    color = Color(0xFF2D6A4F),
                    fontSize = 10.sp,
                    fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
                )

                // Nome do Pokémon
                Text(
                    text = pokemon.name.capitalizePokemonName(),
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Tipos
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    pokemon.types.forEach { type ->
                        val typeColor = getTypeDetailsColor(type)

                        Box(
                            modifier = Modifier
                                .shadow(
                                    elevation = 8.dp,
                                    shape = RoundedCornerShape(16.dp),
                                    spotColor = typeColor, // Efeito Glow
                                    ambientColor = typeColor
                                )
                                .background(typeColor, RoundedCornerShape(16.dp))
                                .padding(horizontal = 12.dp, vertical = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = type.uppercase(),
                                color = Color.White,
                                fontSize = 10.sp,
                                fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Lado Direito: Imagem com fundo e borda
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .border(
                        width = 2.dp,
                        color = Color(0xFF2D6A4F),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = pokemon.imageUrl,
                    contentDescription = pokemon.name,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}