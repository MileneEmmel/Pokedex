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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.pokedex.data.Pokemon
import com.example.pokedex.data.PokemonMock
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.Typography
import com.example.pokedex.ui.capitalizePokemonName
import com.example.pokedex.ui.formatPokemonNumber

@Composable
fun EvolutionChainCard(pokemon: Pokemon, modifier: Modifier = Modifier) {
    val shape = RoundedCornerShape(24.dp)

    // Converte a lista de nomes das evoluções em objetos 'Pokemon' completos do mock
    val evolutionPokemons = remember(pokemon.evolutions) {
        pokemon.evolutions.mapNotNull { name ->
            PokemonMock.pokedex.find { it.name.equals(name, ignoreCase = true) }
        }
    }
    val isEeveeBranchEvolution = remember(evolutionPokemons) {
        evolutionPokemons.size > 2 &&
            evolutionPokemons.firstOrNull()?.name.equals("eevee", ignoreCase = true)
    }

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

            // Caso o Pokémon não tenha evoluções, exibe apenas ele mesmo
            if (evolutionPokemons.size <= 1) {
                EvolutionItem(evo = pokemon, isSelected = true)
            } else if (isEeveeBranchEvolution) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    val baseEvolution = evolutionPokemons.first()
                    EvolutionItem(
                        evo = baseEvolution,
                        isSelected = pokemon.id == baseEvolution.id
                    )

                    // Eevee branches to multiple options, so keep a single connector.
                    ArrowDown()

                    evolutionPokemons.drop(1).forEach { evo ->
                        EvolutionItem(
                            evo = evo,
                            isSelected = pokemon.id == evo.id
                        )
                    }
                }
            } else {
                Column(
                    modifier            = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Itera pela lista de evolução adicionando uma seta entre os itens
                    evolutionPokemons.forEachIndexed { index, evo ->
                        EvolutionItem(
                            evo = evo,
                            // Destaca o Pokemon selecionado
                            isSelected = pokemon.id == evo.id
                        )

                        // Adiciona a seta apenas se não for o último Pokémon da cadeia de evoluções
                        if (index < evolutionPokemons.size - 1) {
                            ArrowDown()
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EvolutionItem(evo: Pokemon, isSelected: Boolean, modifier: Modifier = Modifier) {
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

        // Imagem do Pokemon
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(ThemeColors.iceGreen, RoundedCornerShape(16.dp))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model              = evo.imageUrl,
                contentDescription = evo.name,
                modifier           = Modifier.fillMaxSize()
            )
        }

        // Nome e número do Pokemon
        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(
                text  = evo.name.capitalizePokemonName(),
                color = ThemeColors.deepGreen,
                style = Typography.gridItemName
            )

            Text(
                text  = evo.id.formatPokemonNumber(),
                color = ThemeColors.deepGreen,
                style = Typography.pixelId()
            )
        }
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