package com.example.pokedex.ui.details.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.data.Pokemon
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

@Composable
fun DescriptionCard(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(2.dp, Color.White, RoundedCornerShape(24.dp)) // Borda branca adicionada
            .background(Color(0xFFFBFBFB), RoundedCornerShape(24.dp))
            .padding(16.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            // Título com ícone
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Description, // Ícone de documento
                    contentDescription = null,
                    tint = Color(0xFF2D6A4F),
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "DESCRIPTION",
                    color    = Color(0xFF2D6A4F),
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
                )
            }

            // Texto da Descrição
            Text(
                text = pokemon.description,
                color = Color(0xFF2D6A4F),
                fontSize = 14.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}