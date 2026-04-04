package com.example.pokedex.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.ui.HeaderSection
import com.example.pokedex.ui.MenuCard
import com.example.pokedex.ui.ThemeColors
import org.jetbrains.compose.resources.painterResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.my_team
import pokedex.composeapp.generated.resources.pokebola

@Composable
fun HomeScreen(onSeePokedexClick: () -> Unit, onSeeTeamClick: () -> Unit = {}) {
    val screenGradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFF86EFAC),
            Color(0xFF22C55E),
            Color(0xFF15803D)
        )
    )


    val contentHorizontalPadding = 16.dp
    val contentTopPadding = 24.dp

    ElevatedCard(
        modifier = Modifier.fillMaxSize(),
        shape = RoundedCornerShape(0.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = Color.Transparent)
    ) {
        Box(
            modifier = Modifier.fillMaxSize().background(screenGradient)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = contentHorizontalPadding, vertical = contentTopPadding)
            ) {
                HeaderSection()

                MenuCard(
                    title = "Pokédex",
                    subtitle = "Explore all available Pokémon",
                    icon = painterResource(Res.drawable.pokebola),
                    modifier = Modifier.padding(top = 26.dp),
                    onClick = onSeePokedexClick
                )

                MenuCard(
                    title = "My Team",
                    subtitle = "Manage your battle squad",
                    icon = painterResource(Res.drawable.my_team),
                    modifier = Modifier.padding(top = 14.dp),
                    onClick = onSeeTeamClick
                )

            }
        }
    }
}