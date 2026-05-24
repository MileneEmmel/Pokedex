package com.example.pokedex.ui.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.local.FavoritePokemonEntity
import com.example.pokedex.data.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TeamViewModel(private val repository: PokemonRepository) : ViewModel() {

    val teamState: StateFlow<List<FavoritePokemonEntity>> = repository.getMyTeamFlow()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Busca o time salvo no Room Database
    fun loadTeam() {
        // Agora o flow cuida da sincronização automática
    }

    // Remove do banco de dados e recarrega a lista
    fun removePokemon(id: Int) {
        viewModelScope.launch {
            repository.removeFavorite(id)
            loadTeam()
        }
    }
}