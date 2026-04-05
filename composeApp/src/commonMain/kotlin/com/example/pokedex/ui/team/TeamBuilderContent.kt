package com.example.pokedex.ui.team

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.team.styles.TeamBuilderStyle

@Composable
fun TeamBuilderContent(
    team: List<Pokemon>,
    style: TeamBuilderStyle,
    onExploreClick: () -> Unit = {},
    onViewDetailsClick: (Int) -> Unit = {},
    onRemovePokemon: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val avgHp = team.mapNotNull { p -> p.stats.firstOrNull { it.name == "hp" }?.value }.averageInt()
    val avgAtk = team.mapNotNull { p -> p.stats.firstOrNull { it.name == "attack" }?.value }.averageInt()
    val avgDef = team.mapNotNull { p -> p.stats.firstOrNull { it.name == "defense" }?.value }.averageInt()
    val avgSpd = team.mapNotNull { p -> p.stats.firstOrNull { it.name == "speed" }?.value }.averageInt()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(style.backgroundBrush)
            .padding(horizontal = 16.dp, vertical = 20.dp),
        // Keeps list items visible below top and bottom scaffold bars.
        contentPadding = PaddingValues(top = 90.dp, bottom = 100.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // TEAM SUMMARY
        item {
            TeamStatusCard(
                teamSize = team.size,
                avgHp = avgHp,
                avgAtk = avgAtk,
                avgDef = avgDef,
                avgSpd = avgSpd
            )
        }

        if (team.isEmpty()) {
            // EMPTY STATE
            item {
                TeamEmptyCard(
                    title = style.emptyTitle,
                    subtitle = style.emptySubtitle,
                    panelColor = style.panelColor,
                    panelBorder = style.panelBorder,
                    titleColor = style.titleColor,
                    subtitleColor = style.subtitleColor,
                    accentColor = style.accentColor,
                    onExploreClick = onExploreClick
                )
            }
        } else {
            // TEAM LIST
            items(team, key = { it.id }) { pokemon ->
                TeamMemberCard(
                    pokemon = pokemon,
                    onViewDetailsClick = { onViewDetailsClick(pokemon.id) },
                    onRemoveClick = { onRemovePokemon(pokemon.id) }
                )
            }

            item { Spacer(modifier = Modifier.height(4.dp)) }
        }
    }
}

private fun List<Int>.averageInt(): Int = if (isEmpty()) 0 else sum() / size