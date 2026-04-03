package com.example.pokedex.ui.scaffold

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

private fun glassBrush() = Brush.verticalGradient(
    colors = listOf(
        Color.White.copy(alpha = 0.25f),
        Color.White.copy(alpha = 0.10f)
    )
)

@Composable
fun GlassTopBar(
    title: String,
    modifier: Modifier = Modifier
) {
    val shape = RectangleShape

    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(6.dp, shape)
            .clip(shape)
            .background(Color(0xFFDCEFE3))
            .border(
                width = 1.dp,
                color = Color(0xFFCDE5D6),
                shape = shape
            )
            .padding(top = 24.dp, bottom = 14.dp),
    ) {
        Text(
            text = title,
            modifier = Modifier.align(Alignment.BottomCenter),
            color = Color(0xFF14532D),
            fontFamily = pixelFont(),
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun GlassBottomNav(
    isPokedexSelected: Boolean,
    isTeamSelected: Boolean,
    pokedexIcon: Painter,
    teamIcon: Painter,
    onPokedexClick: () -> Unit,
    onTeamClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RectangleShape

    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(12.dp, shape)
            .clip(shape)
            .background(Color(0xFFDCEFE3))
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            BottomItem(
                label = "POKEDEX",
                icon = pokedexIcon,
                selected = isPokedexSelected,
                onClick = onPokedexClick,
                modifier = Modifier.weight(1f)
            )

            BottomItem(
                label = "MY TEAM",
                icon = teamIcon,
                selected = isTeamSelected,
                onClick = onTeamClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun BottomItem(
    label: String,
    icon: Painter,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(14.dp)

    Box(
        modifier = modifier
            .clip(shape)
            .background(
                if (selected) Color(0xFF16A34A) // verde forte
                else Color.Transparent
            )
            .border(
                width = 2.dp,
                color = if (selected) Color.White else Color(0xFFD1D5DB),
                shape = shape
            )
            .clickable(onClick = onClick)
            .padding(vertical = 14.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Icon(
                painter = icon,
                contentDescription = label,
                tint = if (selected) Color.White else Color(0xFF166534),
                modifier = Modifier.size(22.dp)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = label,
                color = if (selected) Color.White else Color(0xFF166534),
                fontSize = 11.sp,
                fontFamily = pixelFont(),
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
private fun pixelFont(): FontFamily =
    FontFamily(Font(Res.font.press_start_2p_regular))