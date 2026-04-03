package com.example.pokedex.ui.team

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pokedex.data.Pokemon

@Composable
actual fun TeamBuilderScreen(
    team: List<Pokemon>,
    modifier: Modifier
) {
    TeamBuilderIosContent(
        team = team,
        modifier = modifier
    )
}

