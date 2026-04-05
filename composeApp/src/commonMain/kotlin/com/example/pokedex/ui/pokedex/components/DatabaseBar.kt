package com.example.pokedex.ui.pokedex.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.Typography

@Composable
fun DatabaseBar(currentCount: Int, totalCount: Int) {

    val shape = RoundedCornerShape(24.dp)

    // Container principal
    ElevatedCard(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 2.dp)
            .height(56.dp)
            .border(1.dp, Color.White, shape),
        shape     = shape,
        colors    = CardDefaults.elevatedCardColors(containerColor = ThemeColors.lightIceGreen),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp)
    ) {

        Row(
            modifier              = Modifier.fillMaxSize().padding(horizontal = 20.dp),
            verticalAlignment     = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // Título estático
            Text(
                text  = "Database",
                color = ThemeColors.deepGreen,
                style = Typography.placeHolder
            )

            // Contador dinâmico do número de Pokemons listado
            Text(
                text  = "$currentCount/$totalCount",
                color = ThemeColors.deepGreen,
                style = Typography.pixelCounter()
            )
        }
    }
}