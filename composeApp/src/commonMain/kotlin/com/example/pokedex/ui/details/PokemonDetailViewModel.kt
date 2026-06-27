package com.example.pokedex.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.repository.PokemonRepository
import com.example.pokedex.data.repository.PokemonFullDetails
import com.example.pokedex.ui.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PokemonDetailViewModel(
    private val repository: PokemonRepository
) : ViewModel() {

    private val _detailState = MutableStateFlow<UiState<PokemonFullDetails>>(UiState.Loading)
    val detailState: StateFlow<UiState<PokemonFullDetails>> = _detailState.asStateFlow()

    // Busca os dados atualizados diretamente da API
    fun fetchPokemonDetails(id: Int) {
        viewModelScope.launch {
            _detailState.value = UiState.Loading
            try {
                // Dados da tela de detalhes são buscados diretamente da API
                val result = repository.getPokemonDetails(id)
                _detailState.value = UiState.Success(result)
            } catch (e: Exception) {
                _detailState.value = UiState.Error("Erro ao carregar detalhes atualizados. Verifique a internet.")
            }
        }
    }

    // Salva o Pokémon no time (favoritos)
    fun saveToTeam(
        id: Int,
        name: String,
        imageUrl: String,
        captureLocation: String,
        types: String,
        hp: Int,
        attack: Int,
        defense: Int,
        speed: Int,
        latitude: Double? = null,
        longitude: Double? = null,
        photoPath: String? = null
    ) {
        viewModelScope.launch {
            repository.saveFavorite(
                id, name, imageUrl, captureLocation, types, hp, attack, defense, speed,
                latitude, longitude, photoPath
            )
        }
    }
}
