package com.example.pokedex.data.remote

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class KtorPokeApi(private val client: HttpClient = HttpClient {
    install(ContentNegotiation) {
        json(Json {
            ignoreUnknownKeys = true // Ignora campos da API que não mapeamos
            prettyPrint = true
        })
    }
}) {
    private val baseUrl = "https://pokeapi.co/api/v2"

    // Busca a listagem inicial para o cache offline-first
    suspend fun getBasePokemonList(limit: Int = 1000): PokemonListResponse {
        return client.get("$baseUrl/pokemon") {
            url {
                parameters.append("limit", limit.toString())
            }
        }.body()
    }

    // Busca os detalhes direto da API em tempo real
    suspend fun getPokemonDetails(nameOrId: String): PokemonDetailDto {
        return client.get("$baseUrl/pokemon/$nameOrId").body()
    }

    suspend fun getPokemonSpecies(id: String): PokemonSpeciesDto {
        return client.get("$baseUrl/pokemon-species/$id").body()
    }

    suspend fun getEvolutionChain(url: String): EvolutionChainResponseDto {
        return client.get(url).body()
    }

    suspend fun getTypeDetails(nameOrId: String): TypeDetailDto {
        return client.get("$baseUrl/type/$nameOrId").body()
    }
}