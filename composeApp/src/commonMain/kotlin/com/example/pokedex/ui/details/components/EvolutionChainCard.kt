package com.example.pokedex.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pokedex.data.Pokemon
import com.example.pokedex.data.PokemonMock
import com.example.pokedex.ui.AppFonts
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.capitalizePokemonName
import com.example.pokedex.ui.formatPokemonNumber

@Composable
fun EvolutionChainCard(pokemon: Pokemon, modifier: Modifier = Modifier) {
    val shape = RoundedCornerShape(24.dp)

    val evolutionPokemons = remember(pokemon.evolutions) {
        pokemon.evolutions.mapNotNull { name ->
            PokemonMock.pokedex.find { it.name.equals(name, ignoreCase = true) }
        }
    }

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
                text = "EVOLUTION CHAIN",
                color = ThemeColors.deepGreen,
                fontSize = 12.sp,
                fontFamily = AppFonts.pixel()
            )

            if (evolutionPokemons.size <= 1) {
                // SEM EVOLUÇÃO
                EvolutionItem(
                    evo = pokemon,
                    isSelected = true
                )
            } else {

                val isEeveeBranch =
                    evolutionPokemons.first().name.equals("eevee", ignoreCase = true)

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    if (isEeveeBranch) {

                        EvolutionItem(
                            evo = evolutionPokemons.first(),
                            isSelected = pokemon.id == evolutionPokemons.first().id
                        )

                        ArrowDown()

                        evolutionPokemons.drop(1).forEach { evo ->
                            EvolutionItem(
                                evo = evo,
                                isSelected = pokemon.id == evo.id
                            )
                        }

                    } else {

                        evolutionPokemons.forEachIndexed { index, evo ->

                            EvolutionItem(
                                evo = evo,
                                isSelected = pokemon.id == evo.id
                            )

                            if (index < evolutionPokemons.size - 1) {
                                ArrowDown()
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EvolutionItem(
    evo: Pokemon,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(20.dp)

    val borderModifier = if (isSelected) {
        Modifier.border(
            width = 1.dp,
            color = ThemeColors.deepGreen,
            shape = shape
        )
    } else {
        Modifier
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .then(borderModifier)
            .background(Color.White, shape)
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Box(
            modifier = Modifier
                .size(64.dp)
                .background(ThemeColors.iceGreen, RoundedCornerShape(16.dp))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = evo.imageUrl,
                contentDescription = evo.name,
                modifier = Modifier.fillMaxSize()
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text = evo.name.capitalizePokemonName(),
                color = ThemeColors.deepGreen,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = evo.id.formatPokemonNumber(),
                color = ThemeColors.deepGreen,
                fontSize = 10.sp,
                fontFamily = AppFonts.pixel()
            )
        }
    }
}

@Composable
fun ArrowDown() {
    Icon(
        imageVector = Icons.Default.ArrowDownward,
        contentDescription = "Evolves to",
        tint = ThemeColors.deepGreen,
        modifier = Modifier.size(20.dp)
    )
}

