package com.example.pokedex.ui.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.local.FavoritePokemonEntity
import com.example.pokedex.data.repository.PokemonRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class TeamViewModel(private val repository: PokemonRepository) : ViewModel() {

    val teamState: StateFlow<List<FavoritePokemonEntity>> = repository.getMyTeamFlow()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())


    // Remove do banco de dados e recarrega a lista
    fun removePokemon(id: Int) {
        viewModelScope.launch {
            repository.removeFavorite(id)
        }
    }
}