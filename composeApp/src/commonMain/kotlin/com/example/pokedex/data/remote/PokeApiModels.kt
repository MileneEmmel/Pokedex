package com.example.pokedex.data.remote

import kotlinx.serialization.Serializable

// Resposta para a listagem básica inicial (sincronização)
@Serializable
data class PokemonListResponse(
    val results: List<PokemonResult>
)

@Serializable
data class PokemonResult(
    val name: String,
    val url: String
)

// ==========================================
// DTOs PARA A TELA DE DETALHES
// ==========================================
@Serializable
data class PokemonDetailDto(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val types: List<TypeSlotDto>,
    val abilities: List<AbilitySlotDto>,
    val stats: List<StatSlotDto>,
    val species: NamedResourceDto
)

@Serializable
data class NamedResourceDto(val name: String, val url: String)

@Serializable
data class TypeSlotDto(val type: NamedResourceDto)

@Serializable
data class AbilitySlotDto(val ability: NamedResourceDto)

@Serializable
data class StatSlotDto(val base_stat: Int, val stat: NamedResourceDto)

// ==========================================
// DTO PARA BUSCAR A DESCRIÇÃO E DETALHES EXTRAS (Endpoint separado)
// ==========================================
@Serializable
data class PokemonSpeciesDto(
    val flavor_text_entries: List<FlavorTextDto>,
    val gender_rate: Int = -1, // Retorna de -1 a 8
    val evolution_chain: EvolutionChainUrlDto
)

@Serializable
data class FlavorTextDto(
    val flavor_text: String,
    val language: NamedResourceDto
)

@Serializable
data class EvolutionChainUrlDto(
    val url: String
)

// 2. CRIAR os novos DTOs para ler o endpoint de Evoluções
@Serializable
data class EvolutionChainResponseDto(
    val chain: ChainLinkDto
)

@Serializable
data class ChainLinkDto(
    val species: NamedResourceDto,
    val evolves_to: List<ChainLinkDto> // Uma lista dela mesma (Recursividade)
)

@Serializable
data class TypeDetailDto(
    val damage_relations: DamageRelationsDto,
    val pokemon: List<TypePokemonDto> = emptyList()
)

@Serializable
data class TypePokemonDto(
    val pokemon: NamedResourceDto
)

@Serializable
data class DamageRelationsDto(
    val double_damage_from: List<NamedResourceDto>
)
