package com.example.pokedex.ui.team

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.team.styles.TeamBuilderStyle

@Composable
internal fun TeamBuilderIosContent(
    team: List<Pokemon>,
    onExploreClick: () -> Unit,
    onViewDetailsClick: (Int) -> Unit,
    onRemovePokemon: (Int) -> Unit,
    modifier: Modifier
) {
    val background = Brush.verticalGradient(
        listOf(
            ThemeColors.iosBackgroundTop,
            ThemeColors.iosBackgroundBottom
        )
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(background)
    ) {
        Box(
            modifier = Modifier
                .offset(x = 255.dp, y = 68.dp)
                .size(132.dp)
                .clip(CircleShape)
                .background(ThemeColors.iosDecorMint.copy(alpha = 0.35f))
        )
        Box(
            modifier = Modifier
                .offset(x = 16.dp, y = 414.dp)
                .size(118.dp)
                .clip(CircleShape)
                .background(ThemeColors.iosDecorMintSoft.copy(alpha = 0.70f))
        )

        val style = TeamBuilderStyle(
            backgroundBrush = background,
            panelColor = ThemeColors.white.copy(alpha = 0.90f),
            panelBorder = ThemeColors.iosPanelBorder,
            titleColor = ThemeColors.iosTitle,
            subtitleColor = ThemeColors.iosSubtitle,
            chipBackground = ThemeColors.iosMintSurface,
            chipTextColor = ThemeColors.deepGreen,
            badgeColor = ThemeColors.iosMintSurface,
            accentColor = ThemeColors.iosAccent,
            headerTitle = "My Team",
            headerSubtitle = "A clean roster ready for the next battle.",
            emptyTitle = "No Pokémon yet",
            emptySubtitle = "Your roster will appear here after you add a Pokémon from the Pokédex."
        )

        TeamBuilderContent(
            team = team,
            style = style,
            onExploreClick = onExploreClick,
            onViewDetailsClick = onViewDetailsClick,
            onRemovePokemon = onRemovePokemon
        )
    }
}

