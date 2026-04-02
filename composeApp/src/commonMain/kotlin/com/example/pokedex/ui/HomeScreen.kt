package com.example.pokedex.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.ic_bolt
import pokedex.composeapp.generated.resources.ic_groups

@Composable
fun HomeScreen(
    onSeePokedexClick: () -> Unit,
    onSeeTeamClick: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(HomeStyleTokens.screenGradient)
    ) {
        DecorativeBackground()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(
                    horizontal = HomeStyleTokens.contentHorizontalPadding,
                    vertical = HomeStyleTokens.contentTopPadding
                )
        ) {
            HeaderSection()
            StatsCard(modifier = Modifier.padding(top = HomeStyleTokens.sectionSpacing))

            MenuCard(
                title = "Pokédex",
                subtitle = "Explore all available Pokémon",
                icon = painterResource(Res.drawable.ic_bolt),
                iconBackground = HomeStyleTokens.primaryMenuIconGradient,
                iconTint = HomeStyleTokens.neonYellow,
                modifier = Modifier.padding(top = 26.dp),
                onClick = onSeePokedexClick
            )

            MenuCard(
                title = "My Team",
                subtitle = "Manage your battle squad",
                icon = painterResource(Res.drawable.ic_groups),
                iconBackground = HomeStyleTokens.teamMenuIconGradient,
                accentColor = HomeStyleTokens.neonYellow.copy(alpha = 0.18f),
                modifier = Modifier.padding(top = 14.dp),
                onClick = onSeeTeamClick
            )

            FooterPill(modifier = Modifier.padding(top = 28.dp, bottom = 10.dp))
        }
    }
}

@Composable
private fun DecorativeBackground() {
    Box(
        modifier = Modifier
            .offset(x = 230.dp, y = 90.dp)
            .size(110.dp)
            .clip(CircleShape)
            .background(Color.White.copy(alpha = 0.10f))
    )
    Box(
        modifier = Modifier
            .offset(x = 14.dp, y = 430.dp)
            .size(135.dp)
            .clip(CircleShape)
            .background(Color.White.copy(alpha = 0.08f))
    )
}
