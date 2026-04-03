package com.example.pokedex.ui.pokedex

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.pokedex.components.DatabaseBar
import com.example.pokedex.ui.pokedex.components.SearchAndFilterBar
import com.example.pokedex.ui.pokedex.components.PokemonGridItem

@Composable
fun PokedexGridScreen(pokemons: List<Pokemon>, onPokemonClick: (Int) -> Unit) {

    var searchQuery by remember { mutableStateOf("") }
    var selectedType by remember { mutableStateOf<String?>(null) }

    val filteredList = pokemons.filter {
        val matchesName = it.name.contains(searchQuery, ignoreCase = true)
        val matchesType = selectedType == null || it.types.contains(selectedType)
        matchesName && matchesType
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFFD0EBD1), Color(0xFFA5E0CC)
                    )
                )
            )
            .padding(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                DatabaseBar(
                    currentCount = filteredList.size,
                    totalCount = pokemons.size
                )
            }

            item(span = { GridItemSpan(maxLineSpan) }) {
                SearchAndFilterBar(
                    searchQuery = searchQuery,
                    onSearchQueryChange = { searchQuery = it },
                    types = pokemons.flatMap { it.types }.distinct(),
                    selectedType = selectedType,
                    onTypeSelected = { selectedType = it }
                )
            }

            items(filteredList) { pokemon ->
                PokemonGridItem(
                    pokemon = pokemon,
                    onClick = { onPokemonClick(pokemon.id) }
                )
            }
        }
    }
}