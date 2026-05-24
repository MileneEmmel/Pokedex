package com.example.pokedex.ui.pokedex

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.UiState
import com.example.pokedex.ui.pokedex.components.DatabaseBar
import com.example.pokedex.ui.pokedex.components.SearchAndFilterBar
import com.example.pokedex.ui.pokedex.components.PokemonGridItem

@Composable
fun PokedexGridScreen(
    viewModel: PokedexViewModel,
    onPokemonClick: (Int) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val searchQuery by viewModel.searchQuery.collectAsState()
    val selectedType by viewModel.selectedType.collectAsState()
    val totalCacheCount by viewModel.totalCacheCount.collectAsState()

    // Lista de tipos disponíveis (PokeAPI não traz os tipos detalhados)
    val availableTypes = listOf("normal", "fire", "water", "grass", "electric", "ice", "fighting", "poison", "ground", "flying", "psychic", "bug", "rock", "ghost", "dark", "dragon", "steel", "fairy")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(ThemeColors.topBackground, ThemeColors.bottomBackground))
            )
            .padding(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Controle de estados (Loading, Success, Error)
        when (val state = uiState) {
            is UiState.Loading -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(color = Color.White)
                }
            }
            is UiState.Error -> {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Erro: ${state.message}", color = Color.White)
                }
            }
            is UiState.Success -> {
                val filteredList = state.data 
                val gridState    = rememberLazyGridState()

                // Paginação: Carrega mais itens quando chega perto do fim
                val shouldLoadMore = remember {
                    derivedStateOf {
                        val lastVisibleItem = gridState.layoutInfo.visibleItemsInfo.lastOrNull()
                            ?: return@derivedStateOf false
                        lastVisibleItem.index >= gridState.layoutInfo.totalItemsCount - 5
                    }
                }

                LaunchedEffect(shouldLoadMore.value) {
                    if (shouldLoadMore.value) {
                        viewModel.loadMore()
                    }
                }

                LazyVerticalGrid(
                    state    = gridState,
                    columns  = GridCells.Fixed(2),
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement   = Arrangement.spacedBy(12.dp),
                    contentPadding        = PaddingValues(top = 90.dp, bottom = 100.dp),
                ) {

                    item(span = { GridItemSpan(maxLineSpan) }) {
                        DatabaseBar(currentCount = filteredList.size, totalCount = totalCacheCount)
                    }

                    item(span = { GridItemSpan(maxLineSpan) }) {
                        SearchAndFilterBar(
                            searchQuery         = searchQuery,
                            onSearchQueryChange = { viewModel.updateSearchQuery(it) },
                            types          = availableTypes,
                            selectedType   = selectedType,
                            onTypeSelected = { viewModel.updateSelectedType(it) }
                        )
                    }

                    items(
                        items = filteredList,
                        key   = { it.id }
                    ) { pokemonCache ->

                        // Se o Pokémon tiver apenas um tipo ou nenhum tipo, tenta buscar os tipos detalhados
                        LaunchedEffect(pokemonCache.id, selectedType) {
                            val hasOnlyOneType = !pokemonCache.types.contains(",")
                            if (pokemonCache.types.isBlank() || (selectedType != null && hasOnlyOneType)) {
                                viewModel.fetchPokemonTypes(pokemonCache.id)
                            }
                        }

                        val mappedTypes = if (pokemonCache.types.isNotBlank()) {
                            pokemonCache.types.split(",")
                        } else {
                            listOf("...") // Mostra reticências até baixar os tipos reais
                        }

                        // Mapeia o Pokémon do cache para o modelo de exibição, usando os tipos disponíveis
                        val mappedPokemon = Pokemon(
                            id       = pokemonCache.id,
                            name     = pokemonCache.name,
                            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${pokemonCache.id}.png",
                            types    = mappedTypes,
                            height   = 0.0, weight = 0.0, abilities = emptyList(), gender = "", weaknesses = emptyList(), evolutions = emptyList(), stats = emptyList(), description = ""
                        )

                        PokemonGridItem(
                            pokemon = mappedPokemon,
                            onClick = { onPokemonClick(mappedPokemon.id) }
                        )
                    }
                }
            }
        }
    }
}