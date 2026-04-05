package com.example.pokedex.ui.pokedex.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.Typography
import com.example.pokedex.ui.capitalizePokemonName
import com.example.pokedex.ui.formatPokemonNumber
import com.example.pokedex.ui.getTypeColor

@Composable
fun PokemonGridItem(pokemon: Pokemon, onClick: () -> Unit) {

    val shape = RoundedCornerShape(20.dp)

    ElevatedCard(
        onClick   = onClick,
        shape     = shape,
        colors    = CardDefaults.elevatedCardColors(containerColor = Color.White),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        modifier  = Modifier.fillMaxWidth().border(1.dp, Color.White, shape)) {
        Column {
            // Parte superior: Número e imagem do Pokemon
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .background(ThemeColors.iceGreen)
            ) {
                // Número do Pokemon
                Text(
                    text  = pokemon.id.formatPokemonNumber(),
                    color = ThemeColors.deepGreen,
                    style = Typography.pixelGridItem(),
                    modifier = Modifier.align(Alignment.TopCenter).padding(top = 6.dp)
                )

                // Imagem do Pokemon
                AsyncImage(
                    model              = pokemon.imageUrl,
                    contentDescription = pokemon.name,
                    modifier           = Modifier.size(100.dp).align(Alignment.BottomCenter)
                )
            }

            // Parte inferior: Nome e tipos do Pokemon
            Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                // Nome do Pokemon
                Text(
                    text  = pokemon.name.capitalizePokemonName(),
                    color = ThemeColors.deepGreen,
                    style = Typography.gridItemName
                )
                Spacer(modifier = Modifier.height(6.dp))

                // Tipos do Pokemon -> Listados horizontalmente
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    pokemon.types.forEach { type ->
                        // Cor correspondente ao tipo para o background do texto
                        val typeColor = getTypeColor(type)

                        Box(
                            modifier = Modifier
                                .background(typeColor, RoundedCornerShape(12.dp))
                                .padding(horizontal = 8.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text  = type.uppercase(),
                                color = Color.White,
                                style = Typography.pixelGridItem()
                            )
                        }
                    }
                }
            }
        }
    }
}