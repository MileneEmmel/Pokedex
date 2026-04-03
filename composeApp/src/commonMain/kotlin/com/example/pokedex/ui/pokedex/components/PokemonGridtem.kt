package com.example.pokedex.ui.pokedex.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.capitalizePokemonName
import com.example.pokedex.ui.formatPokemonNumber
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

@Composable
fun PokemonGridItem(pokemon: Pokemon, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp, RoundedCornerShape(20.dp))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Metade Superior (Fundo Verde Claro com a Imagem)
            Box(
                modifier = Modifier.fillMaxWidth().height(130.dp).background(Color(0xFFD5EED8))
            ) {
                // Pílula com o Número (Canto Superior Esquerdo)
                Box(
                    modifier = Modifier.align(Alignment.TopCenter).padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = pokemon.id.formatPokemonNumber(),
                        color = Color(0xFF2D6A4F),
                        fontSize = 10.sp,
                        fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
                    )
                }

                // Imagem do Pokémon
                AsyncImage(
                    model = pokemon.imageUrl,
                    contentDescription = pokemon.name,
                    modifier = Modifier.size(100.dp).align(Alignment.BottomCenter)
                )
            }

            // Metade Inferior (Textos e Tipos no fundo branco)
            Column(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = pokemon.name.capitalizePokemonName(),
                    color = Color(0xFF1B4332),
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Tipos em Linha
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    pokemon.types.forEach { type ->
                        val typeColor = getTypeColor(type)

                        Box(
                            modifier = Modifier
                                .shadow(
                                    elevation = 8.dp,
                                    shape = RoundedCornerShape(12.dp),
                                    spotColor = typeColor,    // Cria o efeito de "Glow" colorido
                                    ambientColor = typeColor
                                )
                                .background(typeColor, RoundedCornerShape(12.dp))
                                .padding(horizontal = 8.dp, vertical = 4.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = type.uppercase(),
                                color = Color.White,
                                fontSize = 9.sp,
                                fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
                            )
                        }
                    }
                }
            }
        }
    }
}

// Função auxiliar para mapear as cores de cada tipo
fun getTypeColor(type: String): Color {
    return when (type.lowercase()) {
        "grass"    -> Color(0xFF38E54D)
        "poison"   -> Color(0xFFA020F0)
        "fire"     -> Color(0xFFFF5722)
        "water"    -> Color(0xFF29B6F6)
        "electric" -> Color(0xFFFFEB3B)
        "psychic"  -> Color(0xFFFF4081)
        "bug"      -> Color(0xFFA2C11C)
        "normal"   -> Color(0xFFA8A878)
        else       -> Color(0xFFBDBDBD)
    }
}