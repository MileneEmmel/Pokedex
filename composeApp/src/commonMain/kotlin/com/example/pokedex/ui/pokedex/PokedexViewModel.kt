package com.example.pokedex.ui.pokedex

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.local.PokemonCacheEntity
import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.ui.UiState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class PokedexViewModel(
    private val repository: PokemonRepository
) : ViewModel() {

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery.asStateFlow()

    private val _selectedType = MutableStateFlow<String?>(null)
    val selectedType: StateFlow<String?> = _selectedType.asStateFlow()

    private val _currentLimit = MutableStateFlow(20) // Começa com 20

    // Estado reativo da UI combinando filtros, paginação e banco de dados
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
            // Se a lista está vazia mas NÃO estamos filtrando, aí sim é Loading inicial
            if (pokemons.isEmpty() && _searchQuery.value.isEmpty() && _selectedType.value == null) {
                UiState.Loading
            } else {
                // Se a lista está vazia mas tem filtro, é Sucesso (lista vazia), a UI trata como "Não encontrado"
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
                // Se falhar por falta de internet no primeiro acesso, logamos aqui
                println("Erro na sincronização: ${e.message}")
            }
        }
    }

    // Função para a UI chamar quando o scroll chegar ao fim
    fun loadMore() {
        _currentLimit.value += 20
    }

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
        _currentLimit.value = 20 // Reseta o limite ao pesquisar
    }

    fun updateSelectedType(type: String?) {
        val normalizedType = if (type == "All" || type.isNullOrBlank()) null else type.lowercase()
        _selectedType.value = normalizedType
        _currentLimit.value = 20 // Reseta o limite ao filtrar
        
        // Se um tipo foi selecionado, sincronizamos os Pokémons desse tipo para garantir que apareçam no filtro
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
