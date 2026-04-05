package com.example.pokedex.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.PokemonMock
import com.example.pokedex.ui.HeaderSection
import com.example.pokedex.ui.MenuCard
import org.jetbrains.compose.resources.painterResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.my_team
import pokedex.composeapp.generated.resources.pokebola

@Composable
fun HomeScreen(
    onSeePokedexClick: () -> Unit,
    onSeeTeamClick: () -> Unit = {}
) {
    val pokemons = remember { PokemonMock.getPokemonList() }
    val pokemonCountStr = pokemons.size.toString()
    val typesCountStr = pokemons.flatMap { it.types }.distinct().size.toString()

    val screenGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF86EFAC),
            Color(0xFF22C55E),
            Color(0xFF15803D)
        )
    )

    ElevatedCard(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(0.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier.fillMaxSize().background(screenGradient)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    // Padding do topo reduzido para a imagem subir
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HeaderSection()

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp, bottom = 8.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    StatItem(value = pokemonCountStr, label = "Pokémon", valueColor = Color.White)
                    StatItem(value = typesCountStr, label = "Types", valueColor = Color(0xFFFDE047))
                    StatItem(value = "6", label = "Max Team", valueColor = Color(0xFF93C5FD))
                }

                MenuCard(
                    title = "Pokédex",
                    subtitle = "Explore all available Pokémon",
                    icon = painterResource(Res.drawable.pokebola),
                    modifier = Modifier.padding(top = 8.dp),
                    onClick = onSeePokedexClick
                )

                MenuCard(
                    title = "My Team",
                    subtitle = "Manage your battle squad",
                    icon = painterResource(Res.drawable.my_team),
                    modifier = Modifier.padding(top = 14.dp),
                    onClick = onSeeTeamClick
                )
            }
        }
    }
}