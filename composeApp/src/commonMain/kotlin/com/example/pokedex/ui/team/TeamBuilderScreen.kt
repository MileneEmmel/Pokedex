package com.example.pokedex.ui.team

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pokedex.data.Pokemon

@Composable
expect fun TeamBuilderScreen(
    team: List<Pokemon>,
    onExploreClick: () -> Unit,
    onViewDetailsClick: (Int) -> Unit,
    onRemovePokemon: (Int) -> Unit,
    modifier: Modifier
)
