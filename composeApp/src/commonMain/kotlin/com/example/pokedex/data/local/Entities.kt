package com.example.pokedex.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

// 1. Tabela para o Cache Offline-First (Sincronização Inicial)
@Entity(tableName = "pokemon_cache")
data class PokemonCacheEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val url: String,
    // Vamos armazenar os tipos como uma String separada por vírgulas para facilitar o filtro LIKE exigido
    val types: String
)

// 2. Tabela para o Time (Favoritos) com a nova Regra de Negócio
@Entity(tableName = "favorite_pokemon")
data class FavoritePokemonEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val imageUrl: String,
    val captureLocation: String,
    val types: String,
    val hp: Int,
    val attack: Int,
    val defense: Int,
    val speed: Int
)