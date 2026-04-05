package com.example.pokedex.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SportsMma
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.Typography
import com.example.pokedex.ui.capitalizePokemonName
import com.example.pokedex.ui.getTypeColor

@Composable
fun AbilitiesCard(pokemon: Pokemon, modifier: Modifier = Modifier) {

    val shape = RoundedCornerShape(24.dp)

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, androidx.compose.ui.graphics.Color.White, shape),
        shape     = shape,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        colors    = CardDefaults.elevatedCardColors(containerColor = ThemeColors.lightIceGreen)
    ) {
        Column(
            modifier = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            Row(
                verticalAlignment     = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon( // Ícone
                    imageVector        = Icons.Default.SportsMma,
                    contentDescription = null,
                    tint               = ThemeColors.deepGreen,
                    modifier           = Modifier.size(20.dp)
                )

                Text( // Título
                    text  = "ABILITIES",
                    color = ThemeColors.deepGreen,
                    style = Typography.pixelCardTitle()
                )
            }

            // Lista horizontalmente as habilidades e se faltar espaço joga para a linha de baixo
            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement   = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                pokemon.abilities.forEach { ability ->

                    // Cor correspondente ao tipo para o background do texto
                    val typeColors = pokemon.types.map { getTypeColor(it) }

                    // Fundo da habilidade: Gradiente se o Pokémon tiver mais de um tipo
                    val backgroundModifier = when (typeColors.size) {
                        0 -> Modifier.background( // Sem tipos
                            color = ThemeColors.iceGreen,
                            shape = RoundedCornerShape(16.dp)
                        )

                        1 -> Modifier.background( // Um tipo
                            color = typeColors.first(),
                            shape = RoundedCornerShape(16.dp)
                        )

                        else -> Modifier.background( // Dois tipos
                            brush = Brush.horizontalGradient(listOf(typeColors[0], typeColors[1])),
                            shape = RoundedCornerShape(16.dp)
                        )
                    }

                    // Renderiza cada habilidade com a cor calculada
                    Box(
                        modifier = Modifier
                            .then(backgroundModifier)
                            .padding(horizontal = 14.dp, vertical = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text  = ability.capitalizePokemonName(),
                            color = ThemeColors.lightIceGreen,
                            style = Typography.pixelAbility()
                        )
                    }
                }
            }
        }
    }
}