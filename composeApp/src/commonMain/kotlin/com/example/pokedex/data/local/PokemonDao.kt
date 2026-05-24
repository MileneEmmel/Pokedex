package com.example.pokedex.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokemonDao {
    // Cache -> Armazena os Pokémons obtidos da API para acesso offline e rápido
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCache(pokemons: List<PokemonCacheEntity>)

    // Limpa o cache para evitar dados desatualizados
    @Query("SELECT COUNT(*) FROM pokemon_cache")
    suspend fun getCacheCount(): Int


    // Consulta paginada com filtros de busca e tipo, retornando um Flow para reatividade
    @Query("""
        SELECT * FROM pokemon_cache 
        WHERE name LIKE '%' || :searchQuery || '%' 
        AND (:type IS NULL OR types LIKE '%' || :type || '%')
        AND id <= 1025
        LIMIT :limit OFFSET :offset
    """)
    fun getPagedPokemonsFlow(
        searchQuery: String,
        type: String?,
        limit: Int,
        offset: Int
    ): kotlinx.coroutines.flow.Flow<List<PokemonCacheEntity>>

    // Atualiza os tipos de um Pokémon específico
    @Query("UPDATE pokemon_cache SET types = :types WHERE id = :id")
    suspend fun updatePokemonTypes(id: Int, types: String)

    // Atualiza os tipos de múltiplos Pokémons, adicionando o tipo apenas se ele ainda não estiver presente
    @Query("UPDATE pokemon_cache SET types = CASE WHEN types = '' THEN :type ELSE types || ',' || :type END WHERE name IN (:names) AND types NOT LIKE '%' || :type || '%'")
    suspend fun updateTypesForNames(names: List<String>, type: String)

    // Adiciona aos Favoritos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFavorite(pokemon: FavoritePokemonEntity)

    // Remove dos Favoritos
    @Query("DELETE FROM favorite_pokemon WHERE id = :id")
    suspend fun deleteFavorite(id: Int)

    // Pega todos Favoritos
    @Query("SELECT * FROM favorite_pokemon")
    fun getAllFavoritesFlow(): kotlinx.coroutines.flow.Flow<List<FavoritePokemonEntity>>

    // Conta o total de Pokémons no cache
    @Query("SELECT COUNT(*) FROM pokemon_cache")
    fun getCacheCountFlow(): kotlinx.coroutines.flow.Flow<Int>
}