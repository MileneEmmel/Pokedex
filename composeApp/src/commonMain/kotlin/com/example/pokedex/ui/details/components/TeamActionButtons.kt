package com.example.pokedex.ui.details.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TeamActionButtons(
    onAddToTeamClick: () -> Unit,
    onViewTeamClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        // Add to Team
        Button(
            onClick = onAddToTeamClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .shadow(4.dp, RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0D9488)
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "ADD TO TEAM",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        //View Team
        Button(
            onClick = onViewTeamClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .shadow(2.dp, RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White
            )
        ) {
            Text(
                text = "VIEW TEAM",
                color = Color(0xFF0D9488),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}