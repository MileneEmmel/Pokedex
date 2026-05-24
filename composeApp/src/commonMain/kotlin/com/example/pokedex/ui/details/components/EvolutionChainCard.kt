package com.example.pokedex.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowOutward
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.Typography
import com.example.pokedex.ui.capitalizePokemonName
import com.example.pokedex.ui.formatPokemonNumber
import com.example.pokedex.data.EvolutionMember

@Composable
fun EvolutionChainCard(pokemon: Pokemon, modifier: Modifier = Modifier) {
    val shape = RoundedCornerShape(24.dp)

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, Color.White, shape),
        shape     = shape,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        colors    = CardDefaults.elevatedCardColors(containerColor = ThemeColors.lightIceGreen)
    ) {
        Column(
            modifier            = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // Título
            Row(
                verticalAlignment     = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon( // Ícone
                    imageVector        = Icons.Default.ArrowOutward,
                    contentDescription = null,
                    tint               = ThemeColors.deepGreen,
                    modifier           = Modifier.size(20.dp)
                )

                Text( // Título
                    text  = "EVOLUTION CHAIN",
                    color = ThemeColors.deepGreen,
                    style = Typography.pixelCardTitle()
                )
            }

            // Lista de evoluções
            if (pokemon.evolutions.isNotEmpty()) {
                pokemon.evolutions.forEachIndexed { index, member ->
                    EvolutionNameItem(
                        member = member,
                        isSelected = member.name.lowercase() == pokemon.name.lowercase()
                    )

                    if (index < pokemon.evolutions.size - 1) {
                        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                            ArrowDown()
                        }
                    }
                }
            } else {
                // Fallback caso não haja evoluções
                EvolutionNameItem(
                    member     = EvolutionMember(pokemon.id, pokemon.name, pokemon.imageUrl),
                    isSelected = true
                )
            }
        }
    }
}

@Composable
fun EvolutionNameItem(member: com.example.pokedex.data.EvolutionMember, isSelected: Boolean, modifier: Modifier = Modifier) {
    val shape = RoundedCornerShape(20.dp)

    // Borda de destaque no Pokémon selecionado
    val borderModifier = if (isSelected) {
        Modifier.border(width = 1.dp, color = ThemeColors.deepGreen, shape = shape)
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

        // Imagem
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(ThemeColors.iceGreen, RoundedCornerShape(12.dp))
                .padding(4.dp),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model              = member.imageUrl,
                contentDescription = member.name,
                modifier           = Modifier.fillMaxSize()
            )
        }

        // Nome
        Text(
            text  = member.name.capitalizePokemonName(),
            color = ThemeColors.deepGreen,
            style = Typography.gridItemName
        )
    }
}

@Composable
fun ArrowDown() { // Seta
    Icon(
        imageVector        = Icons.Default.ArrowDownward,
        contentDescription = "Evolves to",
        tint               = ThemeColors.deepGreen,
        modifier           = Modifier.size(20.dp)
    )
}