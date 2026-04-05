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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.team.styles.TeamBuilderStyle

@Composable
actual fun TeamBuilderScreen(
    team: List<Pokemon>,
    onExploreClick: () -> Unit,
    onViewDetailsClick: (Int) -> Unit,
    onRemovePokemon: (Int) -> Unit,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(ThemeColors.topBackground, ThemeColors.bottomBackground)
                )
            )
    ) {
        Box(
            modifier = Modifier
                .offset(x = 240.dp, y = 72.dp)
                .size(120.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.10f))
        )
        Box(
            modifier = Modifier
                .offset(x = 18.dp, y = 420.dp)
                .size(140.dp)
                .clip(CircleShape)
                .background(Color.White.copy(alpha = 0.08f))
        )

        val style = TeamBuilderStyle(
            backgroundBrush = Brush.verticalGradient(
                listOf(ThemeColors.topBackground, ThemeColors.bottomBackground)
            ),
            panelColor = ThemeColors.androidTeamPanel,
            panelBorder = ThemeColors.white.copy(alpha = 0.48f),
            titleColor = ThemeColors.androidTeamTitle,
            subtitleColor = ThemeColors.androidTeamSubtitle,
            chipBackground = ThemeColors.white.copy(alpha = 0.78f),
            chipTextColor = ThemeColors.androidTeamChipText,
            badgeColor = ThemeColors.androidTeamBadge.copy(alpha = 0.20f),
            accentColor = ThemeColors.greenPrimary.copy(alpha = 0.7f),
            headerTitle = "MY TEAM",
            headerSubtitle = "",
            emptyTitle = "Team empty",
            emptySubtitle = "Add your favorite Pokémon to build the perfect lineup."
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