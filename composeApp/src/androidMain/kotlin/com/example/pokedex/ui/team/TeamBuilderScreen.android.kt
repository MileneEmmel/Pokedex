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
import com.example.pokedex.ui.team.styles.TeamBuilderStyle

@Composable
actual fun TeamBuilderScreen(
    team: List<Pokemon>,
    onExploreClick: () -> Unit,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(Color(0xFFD0EBD1), Color(0xFFA5E0CC))
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
                listOf(Color(0xFFD0EBD1), Color(0xFFA5E0CC))
            ),
            panelColor = Color(0xFFC9E3CC),
            panelBorder = Color.White.copy(alpha = 0.48f),
            titleColor = Color(0xFF0D5A36),
            subtitleColor = Color(0xFF2A6A4A),
            chipBackground = Color.White.copy(alpha = 0.78f),
            chipTextColor = Color(0xFF315F47),
            badgeColor = Color(0xFF7DFF00).copy(alpha = 0.20f),
            accentColor = Color(0xFF16A34A).copy(alpha = 0.72f),
            headerTitle = "MY TEAM",
            headerSubtitle = "",
            emptyTitle = "Team empty",
            emptySubtitle = "Add your favorite Pokémon to build the perfect lineup."
        )

        TeamBuilderContent(
            team = team,
            style = style,
            onExploreClick = onExploreClick
        )
    }
}