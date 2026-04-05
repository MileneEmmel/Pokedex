package com.example.pokedex.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.AppFonts
import com.example.pokedex.ui.ThemeColors

@Composable
fun DescriptionCard(
    pokemon: Pokemon,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(24.dp)

    ElevatedCard(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = Color.White,
                shape = shape
            ),
        shape = shape,
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = ThemeColors.lightIceGreen
        )
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            // Header
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Description,
                    contentDescription = null,
                    tint = ThemeColors.deepGreen,
                    modifier = Modifier.size(20.dp)
                )

                Text(
                    text = "DESCRIPTION",
                    color = ThemeColors.deepGreen,
                    fontSize = 12.sp,
                    fontFamily = AppFonts.pixel(),
                    fontWeight = FontWeight.Bold
                )
            }

            // Divider
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(ThemeColors.mediumGreen)
            )

            // Texto
            Text(
                text = pokemon.description,
                color = ThemeColors.deepGreen,
                fontSize = 14.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

