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
internal fun TeamBuilderIosContent(
    team: List<Pokemon>,
    onExploreClick: () -> Unit,
    onViewDetailsClick: (Int) -> Unit,
    onRemovePokemon: (Int) -> Unit,
    modifier: Modifier
) {
    val background = Brush.verticalGradient(
        listOf(
            Color(0xFFF6F7F9),
            Color(0xFFEAF6EE)
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
                .background(Color(0xFFB8F2C8).copy(alpha = 0.35f))
        )
        Box(
            modifier = Modifier
                .offset(x = 16.dp, y = 414.dp)
                .size(118.dp)
                .clip(CircleShape)
                .background(Color(0xFFD9F7E3).copy(alpha = 0.70f))
        )

        val style = TeamBuilderStyle(
            backgroundBrush = background,
            panelColor = Color.White.copy(alpha = 0.90f),
            panelBorder = Color(0xFFE5E7EB),
            titleColor = Color(0xFF111827),
            subtitleColor = Color(0xFF4B5563),
            chipBackground = Color(0xFFEAF7EE),
            chipTextColor = Color(0xFF166534),
            badgeColor = Color(0xFFDFF7E7),
            accentColor = Color(0xFF4ADE80),
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

