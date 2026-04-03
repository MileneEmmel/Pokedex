package com.example.pokedex.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.ui.HeaderSection
import com.example.pokedex.ui.HomeStyleTokens
import com.example.pokedex.ui.MenuCard
import org.jetbrains.compose.resources.painterResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.my_team
import pokedex.composeapp.generated.resources.pokebola

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

