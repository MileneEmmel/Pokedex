package com.example.pokedex.ui.scaffold

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object GlassScaffoldTokens {
    val barBorder: Color = Color.White.copy(alpha = 0.50f)
    val topBarCorner: Dp = 0.dp // A TopBar não tem cantos arredondados no React
    val bottomBarCorner: Dp = 24.dp // rounded-t-3xl é próximo a 24.dp
    val tabCorner: Dp = 16.dp // rounded-2xl é próximo a 16.dp

    val pokedexSelectedGradient = Brush.linearGradient(
        listOf(Color(0xFF10B981), Color(0xFF16A34A))
    )
    val pokedexShadowColor = Color(0xFF10B981).copy(alpha = 0.30f)
     val teamSelectedGradient = Brush.linearGradient(
        listOf(Color(0xFF14B8A6), Color(0xFF0891B2))
    )
    val teamShadowColor = Color(0xFF14B8A6).copy(alpha = 0.30f)

    val inactiveTabBackground: Color = Color.White.copy(alpha = 0.40f)
    val inactiveTabBorder: Color = Color.White.copy(alpha = 0.60f)
}