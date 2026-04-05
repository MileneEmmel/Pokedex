package com.example.pokedex.ui.scaffold

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.ui.ThemeColors
import org.jetbrains.compose.resources.painterResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.open_book
import pokedex.composeapp.generated.resources.shield

@Composable
fun GlassBottomNav(
    isPokedexSelected: Boolean,
    isTeamSelected: Boolean,
    onPokedexClick: () -> Unit,
    onTeamClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(
        topStart = 24.dp,
        topEnd = 24.dp
    )

    val sharedGradient = Brush.linearGradient(
        listOf(
            ThemeColors.greenPrimary,
            ThemeColors.greenPrimary.copy(alpha = 0.7f)
        )
    )

    Surface(
        color = ThemeColors.scaffoldBackground.copy(alpha = 0.95f),
        shape = shape,
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 24.dp,
                shape = shape,
                spotColor = ThemeColors.scaffoldShadowStrong.copy(alpha = 0.25f),
                ambientColor = ThemeColors.scaffoldShadowLight.copy(alpha = 0.12f)
            )
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                drawLine(
                    color = Color.White.copy(alpha = 0.4f),
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = strokeWidth * 2
                )
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            GlassBottomNavItem(
                label = "POKEDEX",
                icon = painterResource(Res.drawable.open_book),
                selected = isPokedexSelected,
                selectedBrush = sharedGradient,
                onClick = onPokedexClick,
                modifier = Modifier.weight(1f)
            )

            GlassBottomNavItem(
                label = "MY TEAM",
                icon = painterResource(Res.drawable.shield),
                selected = isTeamSelected,
                selectedBrush = sharedGradient,
                onClick = onTeamClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}



