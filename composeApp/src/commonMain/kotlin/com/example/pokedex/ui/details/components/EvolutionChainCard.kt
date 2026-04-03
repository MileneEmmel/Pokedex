package com.example.pokedex.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pokedex.data.Pokemon
import com.example.pokedex.data.PokemonMock
import com.example.pokedex.ui.capitalizePokemonName
import com.example.pokedex.ui.formatPokemonNumber
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

@Composable
fun EvolutionChainCard(
    pokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    // Transforma a lista de nomes em objetos da Pokédex para termos acesso à imagem e ID
    val evolutionPokemons = remember(pokemon.evolutions) {
        pokemon.evolutions.mapNotNull { name ->
            PokemonMock.pokedex.find { it.name.equals(name, ignoreCase = true) }
        }
    }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(2.dp, Color.White, RoundedCornerShape(24.dp))
            .background(Color(0xFFFBFBFB), RoundedCornerShape(24.dp))
            .padding(16.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            Text(
                text = "EVOLUTION CHAIN",
                color = Color(0xFF2D6A4F),
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
            )

            if (evolutionPokemons.size <= 1) {
                // Pokémon sem evolução
                EvolutionItem(
                    evo = pokemon,
                    isSelected = true
                )
            } else {
                // Tem evoluções (Linear ou Ramificada)
                val isEeveeBranch = evolutionPokemons.first().name.lowercase() == "eevee"

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (isEeveeBranch) {
                        // Lógica Especial para o Eevee
                        EvolutionItem(
                            evo = evolutionPokemons.first(),
                            isSelected = pokemon.id == evolutionPokemons.first().id
                        )
                        ArrowDown()
                        // Lista as ramificações sem setas entre elas
                        evolutionPokemons.drop(1).forEach { evo ->
                            EvolutionItem(
                                evo = evo,
                                isSelected = pokemon.id == evo.id
                            )
                        }
                    } else {
                        // Lógica Linear Normal (Ex: Bulbasaur -> Ivysaur -> Venusaur)
                        // Destaca o Pokémon que o usuário estiver visualizando no momento
                        evolutionPokemons.forEachIndexed { index, evo ->
                            EvolutionItem(
                                evo = evo,
                                isSelected = pokemon.id == evo.id
                            )
                            if (index < evolutionPokemons.size - 1) {
                                ArrowDown() // Coloca a seta apenas se não for o último
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun EvolutionItem(
    evo: Pokemon,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    // Se o item for o Pokémon atual da tela, ganha uma borda verde chamativa.
    // Caso contrário, ganha a borda branca padrão do layout.
    val borderColor = if (isSelected) Color(0xFF16A34A) else Color.White

    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(2.dp, borderColor, RoundedCornerShape(20.dp))
            .background(Color.White, RoundedCornerShape(20.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(Color(0xFFE8F5E9), RoundedCornerShape(16.dp))
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = evo.imageUrl,
                contentDescription = evo.name,
                modifier = Modifier.fillMaxSize()
            )
        }

        // Informações (Nome e Número)
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = evo.name.capitalizePokemonName(),
                color = Color(0xFF1B4332),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = evo.id.formatPokemonNumber(),
                color = Color(0xFF2D6A4F),
                fontSize = 10.sp,
                fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
            )
        }
    }
}

@Composable
fun ArrowDown() {
    Icon(
        imageVector = Icons.Default.ArrowDownward,
        contentDescription = "Evolves to",
        tint = Color(0xFF2D6A4F),
        modifier = Modifier.size(20.dp)
    )
}