package com.example.pokedex.ui.details.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.Typography

@Composable
fun TeamActionButtons(
    onAddToTeamClick: () -> Unit,
    onViewTeamClick: () -> Unit,
    modifier: Modifier = Modifier,
    isInTeam: Boolean = false
) {
    Column(
        modifier            = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Adicionar ao time
        Button(
            onClick  = onAddToTeamClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .shadow(4.dp, RoundedCornerShape(16.dp)),
            shape    = RoundedCornerShape(16.dp),
            colors   = ButtonDefaults.buttonColors(
                // Altera a cor do botão quando o Pokémon está no time
                containerColor         = if (isInTeam) ThemeColors.mediumGreen else ThemeColors.lightIceGreen,
                disabledContainerColor = Color(0xFF16A34A),
                disabledContentColor   = Color.White
            ),
            // Desabilita o clique se o Pokémon já estiver no time
            enabled  = !isInTeam
        ) {
            Row(
                verticalAlignment     = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                // Troca o ícone de '+' para um 'check' quando o Pokémon está no time
                Icon(
                    imageVector        = if (isInTeam) Icons.Default.Check else Icons.Default.Add,
                    contentDescription = if (isInTeam) "Added" else "Add",
                    tint               = ThemeColors.deepGreen,
                    modifier           = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text  = if (isInTeam) "ADDED TO TEAM" else "ADD TO TEAM",
                    color = ThemeColors.deepGreen,
                    style = Typography.gridItemName
                )
            }
        }

        // Ir para tela 'Meu Time'
        Button(
            onClick  = onViewTeamClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .shadow(2.dp, RoundedCornerShape(16.dp)),
            shape    = RoundedCornerShape(16.dp),
            colors   = ButtonDefaults.buttonColors(containerColor = ThemeColors.lightIceGreen)
        ) {
            Text(
                text  = "VIEW TEAM",
                color = ThemeColors.deepGreen,
                style = Typography.gridItemName
            )
        }
    }
}