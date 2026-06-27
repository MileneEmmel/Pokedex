package com.example.pokedex.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

// Tabela para o Cache Offline-First (Sincronização Inicial)
@Entity(tableName = "pokemon_cache")
data class PokemonCacheEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val url: String,
    val types: String
)

// Tabela para o Time (Favoritos)
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
    val speed: Int,
    val latitude: Double? = null,
    val longitude: Double? = null,
    val photoPath: String? = null
)