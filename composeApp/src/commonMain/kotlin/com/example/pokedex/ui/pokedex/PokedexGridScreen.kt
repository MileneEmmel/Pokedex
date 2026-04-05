package com.example.pokedex.ui.pokedex

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.PokemonMock
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.pokedex.components.DatabaseBar
import com.example.pokedex.ui.pokedex.components.SearchAndFilterBar
import com.example.pokedex.ui.pokedex.components.PokemonGridItem

@Composable
fun PokedexGridScreen(onPokemonClick: (Int) -> Unit) {

    // Lista de Pokemons do mock
    val pokemons = remember { PokemonMock.getPokemonList() }

    // Estados do texto digitado na SearchBar e o tipo selecionado no filtro
    var searchQuery by remember { mutableStateOf("") }
    var selectedType by remember { mutableStateOf<String?>(null) }

    // Lista filtrada
    val filteredList by remember(searchQuery, selectedType, pokemons) {
        derivedStateOf { // A lista é recalculada apenas quando SearchBar ou Filtro são modificados
            pokemons.filter { // Filtro

                // Condição 01: Verifica se o nome contém o texto digitado
                val matchesName = it.name.contains(searchQuery, ignoreCase = true)

                // Condição 02: Verifica se o Pokémon possui o tipo selecionado
                val matchesType = selectedType == null || it.types.contains(selectedType)

                // Mantém na lista se atender nas duas condições
                matchesName && matchesType
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient( // Gradiente vertical no background
                    listOf(ThemeColors.topBackground, ThemeColors.bottomBackground)
                )
            )
            .padding(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        // Grid de rolagem com 2 colunas
        LazyVerticalGrid(
            columns  = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement   = Arrangement.spacedBy(12.dp),

            // Padding interno da lista para evitar que os últimos itens fiquem escondidos sob a barra do sistema
            contentPadding        = PaddingValues(top = 90.dp, bottom = 100.dp),
        ) {

            // DatabaseBar -> Ocupa a linha inteira
            item(span = { GridItemSpan(maxLineSpan) }) {
                DatabaseBar(currentCount = filteredList.size, totalCount = pokemons.size)
            }

            // SearchBar + Filtro -> Ocupa a linha inteira
            item(span = { GridItemSpan(maxLineSpan) }) {
                SearchAndFilterBar(
                    searchQuery         = searchQuery,          // Texto atual no campo de busca
                    onSearchQueryChange = { searchQuery = it }, // Flag disparada quando o texto é alterado

                    types          = pokemons.flatMap { it.types }.distinct(), // Todos os tipos sem duplicatas
                    selectedType   = selectedType,                             // Tipo selecionado (null = Todos)
                    onTypeSelected = { selectedType = it }                     // Flag disparada quando o filtro é alterado
                )
            }

            // Renderiza os cards dos Pokémons usando a lista pós filtro
            items(
                items = filteredList,
                key = { it.id } // pokemon.id como chave
            ) { pokemon ->
                PokemonGridItem(
                    pokemon = pokemon,
                    // Quando clickado, retorna o ID do pokemon
                    onClick = { onPokemonClick(pokemon.id) }
                )
            }
        }
    }
}