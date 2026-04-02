package com.example.pokedex.ui

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object HomeStyleTokens {
    val screenGradient = Brush.verticalGradient(
        listOf(
            Color(0xFF34D399),
            Color(0xFF22C55E),
            Color(0xFF0D9488)
        )
    )

    val cardSurface = Color.White.copy(alpha = 0.25f)
    val cardBorder = Color.White.copy(alpha = 0.34f)
    val panelSurface = Color.White.copy(alpha = 0.22f)
    val panelInner = Color(0xFF14532D).copy(alpha = 0.45f)

    val neonGreen = Color(0xFF76FF03)
    val neonYellow = Color(0xFFFFEA00)
    val neonCyan = Color(0xFF00E5FF)

    val primaryMenuIconGradient = Brush.verticalGradient(
        listOf(Color(0xFF10B981), Color(0xFF16A34A))
    )
    val teamMenuIconGradient = Brush.verticalGradient(
        listOf(Color(0xFF14B8A6), Color(0xFF0891B2))
    )

    val contentHorizontalPadding = 16.dp
    val contentTopPadding = 24.dp
    val sectionSpacing = 24.dp
}

