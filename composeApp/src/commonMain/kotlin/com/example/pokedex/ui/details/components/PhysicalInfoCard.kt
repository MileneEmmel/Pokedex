package com.example.pokedex.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Leaderboard
import androidx.compose.material.icons.filled.Straighten
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.Typography
import com.example.pokedex.ui.parseGenderString

@Composable
fun PhysicalInfoCard(pokemon: Pokemon, modifier: Modifier = Modifier) {

    // Calcula as proporções de gênero
    val (maleRatio, femaleRatio) = remember(pokemon.gender) {
        parseGenderString(pokemon.gender)
    }

    val shape = RoundedCornerShape(24.dp)

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, Color.White, shape),
        shape     = shape,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
        colors    = CardDefaults.elevatedCardColors(containerColor = ThemeColors.lightIceGreen)
    ) {
        Column(
            modifier            = Modifier.padding(18.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // InfoItem de Altura e Peso um ao lado do outro
            Row(
                modifier              = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                InfoItem( // Altura
                    title    = "HEIGHT",
                    value    = "${pokemon.height} m",
                    icon     = Icons.Default.Straighten,
                    modifier = Modifier.weight(1f)
                )

                InfoItem( // Peso
                    title    = "WEIGHT",
                    value    = "${pokemon.weight} kg",
                    icon     = Icons.Default.FitnessCenter,
                    modifier = Modifier.weight(1f)
                )
            }

            // Proporção de Gênero
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                Row(
                    verticalAlignment     = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon( // Ícone
                        imageVector        = Icons.Default.Leaderboard,
                        contentDescription = null,
                        tint               = ThemeColors.deepGreen,
                        modifier           = Modifier.size(18.dp)
                    )
                    Text( // Título
                        text  = "GENDER RATIO",
                        color = ThemeColors.deepGreen,
                        style = Typography.pixelCardTitle()
                    )
                }

                // Barra de progresso segmentada
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(24.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(0.5.dp, Color.White, RoundedCornerShape(12.dp)),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // Masculino (Azul)
                    if (maleRatio > 0f) {
                        Box(
                            modifier         = Modifier.weight(maleRatio).fillMaxHeight().background(ThemeColors.lightBlue),
                            contentAlignment = Alignment.Center
                        ) {
                            if (maleRatio >= 20f) {
                                Text(
                                    text     = "♂ ${maleRatio.toInt()}%",
                                    color    = ThemeColors.deepGreen,
                                    style    = Typography.genderLabel,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }

                    // Feminino (Rosa)
                    if (femaleRatio > 0f) {
                        Box(
                            modifier         = Modifier.weight(femaleRatio).fillMaxHeight().background(ThemeColors.pink),
                            contentAlignment = Alignment.Center
                        ) {
                            if (femaleRatio >= 20f) {
                                Text(
                                    text     = "♀ ${femaleRatio.toInt()}%",
                                    color    = ThemeColors.deepGreen,
                                    style    = Typography.genderLabel,
                                    maxLines = 1,
                                    softWrap = false
                                )
                            }
                        }
                    }

                    // Sem gênero (Cinza)
                    if (maleRatio == 0f && femaleRatio == 0f) {
                        Box(
                            modifier         = Modifier.fillMaxSize().background(Color.Gray),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text  = "GENDERLESS",
                                color = ThemeColors.lightIceGreen,
                                style = Typography.genderLabel
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
private fun InfoItem(title: String, value: String, icon: ImageVector, modifier: Modifier = Modifier) {
    Column(
        modifier            = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(
            verticalAlignment     = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon( // Ícone
                imageVector        = icon,
                contentDescription = null,
                tint               = ThemeColors.deepGreen,
                modifier           = Modifier.size(16.dp)
            )
            Text( // Título
                text  = title,
                color = ThemeColors.deepGreen,
                style = Typography.pixelCardTitle()
            )
        }
        Text( // Valor
            text  = value,
            color = ThemeColors.deepGreen,
            style = Typography.descriptionText
        )
    }
}