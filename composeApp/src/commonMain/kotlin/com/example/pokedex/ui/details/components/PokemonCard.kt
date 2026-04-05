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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.AppFonts
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.capitalizePokemonName
import com.example.pokedex.ui.formatPokemonNumber
import com.example.pokedex.ui.getTypeColor

@Composable
fun PokemonCard(pokemon: Pokemon, modifier: Modifier = Modifier) {

    val shape = RoundedCornerShape(24.dp)

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, ThemeColors.borderMediumGreen, shape),
        shape = shape,
        colors = CardDefaults.elevatedCardColors(containerColor = ThemeColors.mediumGreen),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
    ) {

        Row(
            modifier = Modifier.fillMaxWidth().padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Lado esquerdo
            Column(
                modifier = Modifier.weight(1f).height(150.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = pokemon.name.capitalizePokemonName(),
                    color = ThemeColors.deepGreen,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold
                )

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    pokemon.types.forEach { type ->

                        val typeColor = getTypeColor(type)

                        Box(
                            modifier = Modifier
                                .background(typeColor, RoundedCornerShape(16.dp))
                                .border(1.dp, Color.White, RoundedCornerShape(16.dp))
                                .padding(horizontal = 12.dp, vertical = 6.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = type.uppercase(),
                                color = Color.White,
                                fontSize = 10.sp,
                                fontFamily = AppFonts.pixel()
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Lado direito
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(ThemeColors.iceGreen, RoundedCornerShape(20.dp))
                    .border(1.dp, ThemeColors.borderMediumGreen, RoundedCornerShape(20.dp)),
                contentAlignment = Alignment.Center
            ) {

                // Imagem do Pokemon
                AsyncImage(
                    model = pokemon.imageUrl,
                    contentDescription = pokemon.name,
                    modifier = Modifier.fillMaxSize().padding(10.dp)
                )

                // Número do Pokemon
                Text(
                    text = pokemon.id.formatPokemonNumber(),
                    color = ThemeColors.deepGreen,
                    fontSize = 10.sp,
                    fontFamily = AppFonts.pixel(),
                    modifier = Modifier.align(Alignment.TopCenter).padding(top = 6.dp)
                )
            }
        }
    }
}