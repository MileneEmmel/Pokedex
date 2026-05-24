package com.example.pokedex.ui.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.local.PokemonCacheEntity
import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.ui.UiState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.compareTo

class PokedexViewModel(
    private val repository: PokemonRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedType = MutableStateFlow<String?>(null)
    val selectedType: StateFlow<String?> = _selectedType.asStateFlow()

    private val _currentLimit = MutableStateFlow(20) // Começa com 20

    // Pega o total de Pokémons no cache
    val totalCacheCount: StateFlow<Int> = repository.getCacheCountFlow()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0)

    // Combina os filtros e o limite para obter a lista de Pokémons paginada
    @OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
    val uiState: StateFlow<UiState<List<PokemonCacheEntity>>> = combine(
        _searchQuery,
        _selectedType,
        _currentLimit
    ) { query, type, limit -> Triple(query, type, limit) }
        .flatMapLatest { (query, type, limit) ->
            repository.getPagedPokemonsFlow(query, type, limit, 0)
        }
        .map { pokemons ->
            // Se a lista está vazia e não há filtro selecionado, estado Loading
            if (pokemons.isEmpty() && _searchQuery.value.isEmpty() && _selectedType.value == null) {
                UiState.Loading
            } else {
                // Se a lista está vazia mas tem filtro, estado Success -> Lista vazia, UI trata como "Não encontrado"
                UiState.Success(pokemons)
            }
        }
        .catch { erro ->
            emit(UiState.Error("Falha ao carregar Pokémons: ${erro.message}"))
        }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), UiState.Loading)

    init {
        viewModelScope.launch {
            try {
                repository.syncPokemonsIfEmpty()
            } catch (e: Exception) {
                // Falha por falta de internet no primeiro acesso
                println("Erro na sincronização: ${e.message}")
            }
        }
    }

    // Função para a UI chamar quando o scroll chegar ao fim
    fun loadMore() {
        val maxLimit = 1025
        if (_currentLimit.value < maxLimit) {
            _currentLimit.value = minOf(_currentLimit.value + 20, maxLimit)
        }
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
        _currentLimit.value = 20 // Reseta o limite ao pesquisar
    }

    fun updateSelectedType(type: String?) {
        val normalizedType  = if (type == "All" || type.isNullOrBlank()) null else type.lowercase()
        _selectedType.value = normalizedType
        _currentLimit.value = 20 // Reseta o limite ao filtrar
        
        // Se um tipo foi selecionado, sincronizam os Pokémons desse tipo com a API
        if (normalizedType != null) {
            viewModelScope.launch {
                try {
                    repository.syncTypeFilter(normalizedType)
                } catch (e: Exception) {
                    println("Erro na sincronização de tipo: ${e.message}")
                }
            }
        }
    }

    // Busca o tipo de um Pokémon de forma assíncrona quando ele aparece na tela
    fun fetchPokemonTypes(id: Int) {
        viewModelScope.launch {
            try {
                repository.fetchAndSavePokemonTypes(id)
            } catch (e: Exception) {}
        }
    }
}
