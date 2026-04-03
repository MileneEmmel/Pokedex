package com.example.pokedex.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.details.components.PhysicalInfoCard
import com.example.pokedex.ui.details.components.PokemonCard
import com.example.pokedex.ui.details.components.StatsCard
import com.example.pokedex.ui.details.components.WeaknessesCard
import com.example.pokedex.ui.details.components.AbilitiesCard
import com.example.pokedex.ui.details.components.DescriptionCard
import com.example.pokedex.ui.details.components.EvolutionChainCard
import com.example.pokedex.ui.details.components.TeamActionButtons

@Composable
fun PokemonDetailScreen(pokemon: Pokemon?, onBackClick: () -> Unit) {
    if (pokemon == null) {
        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Pokémon não encontrado.",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(Color(0xFFD0EBD1), Color(0xFFA5E0CC)))
            )
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp, vertical = 24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        PokemonCard(pokemon = pokemon)
        DescriptionCard(pokemon = pokemon)
        PhysicalInfoCard(pokemon = pokemon)
        StatsCard(pokemon = pokemon)
        AbilitiesCard(pokemon = pokemon)
        WeaknessesCard(pokemon = pokemon)
        EvolutionChainCard(pokemon = pokemon)


        // Botões de Ação do Time
        TeamActionButtons(
            onAddToTeamClick = {  },
            onViewTeamClick = {  }
        )

        // Espaço extra no final para a GlassBottomNav não cobrir o botão "View Team"
        Spacer(modifier = Modifier.height(80.dp))
    }
}