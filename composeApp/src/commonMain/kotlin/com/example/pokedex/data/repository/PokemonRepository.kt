package com.example.pokedex.data.repository

import com.example.pokedex.data.local.PokemonDao
import com.example.pokedex.data.local.PokemonCacheEntity
import com.example.pokedex.data.local.FavoritePokemonEntity
import com.example.pokedex.data.remote.KtorPokeApi
import com.example.pokedex.data.remote.PokemonDetailDto
import com.example.pokedex.data.remote.ChainLinkDto
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

import com.example.pokedex.data.EvolutionMember

// Classe para encapsular os dados da tela de detalhes
data class PokemonFullDetails(
    val dto: PokemonDetailDto,
    val description: String,
    val gender: String,
    val evolutions: List<EvolutionMember>,
    val weaknesses: List<String>
)

// Gerencia a sincronização entre a API e o cache local -> Fornece os dados para as telas
class PokemonRepository(
    private val api: KtorPokeApi,
    private val dao: PokemonDao
) {
    suspend fun syncPokemonsIfEmpty() {
        val count = dao.getCacheCount()
        if (count == 0) {
            val response = api.getBasePokemonList(limit = 1025)
            val entities = response.results.mapIndexed { index, result ->
                PokemonCacheEntity(
                    id    = index + 1,
                    name  = result.name,
                    url   = result.url,
                    types = ""
                )
            }
            dao.insertAllCache(entities)
        }
    }

    // // Busca os Pokémons paginados do cache local, aplicando filtros de nome e tipo
    fun getPagedPokemonsFlow(searchQuery: String, type: String?, limit: Int, offset: Int) = 
        dao.getPagedPokemonsFlow(searchQuery, type, limit, offset)

    fun getCacheCountFlow() = dao.getCacheCountFlow()

    suspend fun syncTypeFilter(typeName: String) {
        try {
            val typeDetails  = api.getTypeDetails(typeName)
            val pokemonNames = typeDetails.pokemon.map { it.pokemon.name }
            if (pokemonNames.isNotEmpty()) {
                dao.updateTypesForNames(pokemonNames, typeName)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    suspend fun fetchAndSavePokemonTypes(id: Int) {
        try {
            val details = api.getPokemonDetails(id.toString())
            val types   = details.types.joinToString(",") { it.type.name }
            if (types.isNotBlank()) {
                dao.updatePokemonTypes(details.id, types)
            }
        } catch (e: Exception) {}
    }

    // Busca os detalhes completos do Pokémon
    suspend fun getPokemonDetails(id: Int): PokemonFullDetails = coroutineScope {
        val detailDeferred  = async { api.getPokemonDetails(id.toString()) }
        val speciesDeferred = async { api.getPokemonSpecies(id.toString()) }

        val detailDto  = detailDeferred.await()
        val speciesDto = speciesDeferred.await()

        // Atualiza tipos no cache local
        val typesString = detailDto.types.joinToString(",") { it.type.name }
        if (typesString.isNotBlank()) {
            dao.updatePokemonTypes(detailDto.id, typesString)
        }

        // Busca a Evolução
        val evolutionDto = api.getEvolutionChain(speciesDto.evolution_chain.url)

        // Formata a Descrição
        val description = speciesDto.flavor_text_entries
            .firstOrNull { it.language.name == "en" }?.flavor_text
            ?.replace("\n", " ")
            ?.replace("\u000c", " ") 
            ?: "Descrição não disponível."

        // Calcula o Gênero
        val genderRate   = speciesDto.gender_rate
        val genderString = if (genderRate == -1) {
            "Genderless"
        } else {
            val femalePercentage = (genderRate / 8.0) * 100
            val malePercentage   = 100.0 - femalePercentage
            "$malePercentage% M, $femalePercentage% F"
        }

        // Extrai as Evoluções recursivamente com IDs e Imagens
        val evolutionsList = extractEvolutions(evolutionDto.chain)

        // Busca fraquezas
        val weaknesses = mutableSetOf<String>()
        try {
            detailDto.types.forEach { typeSlot ->
                val typeInfo = api.getTypeDetails(typeSlot.type.name)
                typeInfo.damage_relations.double_damage_from.forEach { weaknessType ->
                    weaknesses.add(weaknessType.name)
                }
            }
        } catch (e: Exception) {}

        return@coroutineScope PokemonFullDetails(
            dto         = detailDto,
            description = description,
            gender      = genderString,
            evolutions  = evolutionsList.distinct(),
            weaknesses  = weaknesses.toList()
        )
    }

    private fun extractEvolutions(chain: ChainLinkDto): List<EvolutionMember> {
        val members = mutableListOf<EvolutionMember>()
        
        // Extrai ID da URL: https://pokeapi.co/api/v2/pokemon-species/1/
        val id = chain.species.url.trimEnd('/').split('/').last().toIntOrNull() ?: 0
        
        members.add(
            EvolutionMember(
                id       = id,
                name     = chain.species.name,
                imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
            )
        )
        
        chain.evolves_to.forEach { branch ->
            members.addAll(extractEvolutions(branch))
        }
        return members
    }

    suspend fun saveFavorite(
        id: Int,
        name: String,
        imageUrl: String,
        captureLocation: String,
        types: String,
        hp: Int,
        attack: Int,
        defense: Int,
        speed: Int
    ) {
        dao.insertFavorite(
            FavoritePokemonEntity(
                id, name, imageUrl, captureLocation, types, hp, attack, defense, speed
            )
        )
    }

    suspend fun removeFavorite(id: Int) = dao.deleteFavorite(id)
    fun getMyTeamFlow() = dao.getAllFavoritesFlow()
}
