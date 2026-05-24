package com.example.pokedex.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokemonDao {

    // ==========================================
    // PARTE 1: CACHE DA LISTA PRINCIPAL
    // ==========================================

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCache(pokemons: List<PokemonCacheEntity>)

    @Query("SELECT COUNT(*) FROM pokemon_cache")
    suspend fun getCacheCount(): Int

    // Paginação e Filtros Nativos no SQL exigidos na M2
    @Query("""
        SELECT * FROM pokemon_cache 
        WHERE name LIKE '%' || :searchQuery || '%' 
        AND (:type IS NULL OR types LIKE '%' || :type || '%')
        LIMIT :limit OFFSET :offset
    """)
    suspend fun getPagedPokemons(
        searchQuery: String,
        type: String?,
        limit: Int,
        offset: Int
    ): List<PokemonCacheEntity>

    @Query("""
        SELECT * FROM pokemon_cache 
        WHERE name LIKE '%' || :searchQuery || '%' 
        AND (:type IS NULL OR types LIKE '%' || :type || '%')
        LIMIT :limit OFFSET :offset
    """)
    fun getPagedPokemonsFlow(
        searchQuery: String,
        type: String?,
        limit: Int,
        offset: Int
    ): kotlinx.coroutines.flow.Flow<List<PokemonCacheEntity>>

    @Query("UPDATE pokemon_cache SET types = :types WHERE id = :id")
    suspend fun updatePokemonTypes(id: Int, types: String)

    @Query("UPDATE pokemon_cache SET types = CASE WHEN types = '' THEN :type ELSE types || ',' || :type END WHERE name IN (:names) AND types NOT LIKE '%' || :type || '%'")
    suspend fun updateTypesForNames(names: List<String>, type: String)

    // ==========================================
    // PARTE 2: FAVORITOS E REGRA DE NEGÓCIO
    // ==========================================

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(pokemon: FavoritePokemonEntity)

    @Query("DELETE FROM favorite_pokemon WHERE id = :id")
    suspend fun deleteFavorite(id: Int)

    @Query("SELECT * FROM favorite_pokemon")
    fun getAllFavoritesFlow(): kotlinx.coroutines.flow.Flow<List<FavoritePokemonEntity>>

    @Query("SELECT * FROM favorite_pokemon")
    suspend fun getAllFavorites(): List<FavoritePokemonEntity>

    @Query("SELECT EXISTS(SELECT 1 FROM favorite_pokemon WHERE id = :id)")
    suspend fun isFavorite(id: Int): Boolean
}