package com.example.pokedex.ui.scaffold

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.Font
import org.jetbrains.compose.resources.painterResource
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.open_book
import pokedex.composeapp.generated.resources.press_start_2p_regular
import pokedex.composeapp.generated.resources.shield

@Composable
fun GlassTopBar(
    title: String,
    showBack: Boolean,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color(0xFFDCFCE7).copy(alpha = 0.60f))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (showBack) {
                val backShape = RoundedCornerShape(12.dp)
                Box(
                    modifier = Modifier
                        .background(Color.White.copy(alpha = 0.40f), backShape)
                        .border(1.dp, Color.White.copy(alpha = 0.50f), backShape)
                        .clip(backShape)
                        .clickable(onClick = onBackClick)
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = Color(0xFF14532D),
                        modifier = Modifier.size(20.dp)
                    )
                }
            } else {
                Spacer(modifier = Modifier.size(56.dp))
            }

            Text(
                text = title,
                color = Color(0xFF14532D),
                style = TextStyle(
                    fontFamily = pixelFont(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                ),
                maxLines = 1,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.size(56.dp))
        }
    }
}

@Composable
fun GlassBottomNav(
    isPokedexSelected: Boolean,
    isTeamSelected: Boolean,
    onPokedexClick: () -> Unit,
    onTeamClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bottomShape = RoundedCornerShape(
        topStart = GlassScaffoldTokens.bottomBarCorner,
        topEnd = GlassScaffoldTokens.bottomBarCorner
    )

    Surface(
        color = Color.White.copy(alpha = 0.30f),
        shape = bottomShape,
        shadowElevation = 20.dp,
        modifier = modifier
            .fillMaxWidth()
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                drawLine(
                    color = Color.White.copy(alpha = 0.40f),
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = strokeWidth * 3
                )
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            GlassBottomNavItem(
                label = "POKEDEX",
                icon = painterResource(Res.drawable.open_book),
                selected = isPokedexSelected,
                selectedBrush = GlassScaffoldTokens.pokedexSelectedGradient,
                shadowColor = Color(0xFF10B981).copy(alpha = 0.3f),
                onClick = onPokedexClick,
                modifier = Modifier.weight(1f)
            )

            GlassBottomNavItem(
                label = "MY TEAM",
                icon = painterResource(Res.drawable.shield),
                selected = isTeamSelected,
                selectedBrush = GlassScaffoldTokens.teamSelectedGradient,
                shadowColor = Color(0xFF14B8A6).copy(alpha = 0.3f),
                onClick = onTeamClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun GlassBottomNavItem(
    label: String,
    icon: Painter,
    selected: Boolean,
    selectedBrush: Brush,
    shadowColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(GlassScaffoldTokens.tabCorner)
    val scale by animateFloatAsState(if (selected) 1.05f else 1f)

    Box(
        modifier = modifier
            .scale(scale)
            .then(
                if (selected) Modifier.shadow(
                    elevation = 15.dp,
                    shape = shape,
                    ambientColor = shadowColor,
                    spotColor = shadowColor
                ) else Modifier
            )
            .background(
                color = if (selected) Color.Transparent else Color.White.copy(alpha = 0.20f),
                shape = shape
            )
            .background(
                brush = if (selected) selectedBrush else Brush.verticalGradient(listOf(Color.Transparent, Color.Transparent)),
                shape = shape
            )
            .border(
                width = 1.dp,
                color = if (selected) Color.White.copy(alpha = 0.50f) else Color.White.copy(alpha = 0.30f),
                shape = shape
            )
            .clip(shape)
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Icon(
                painter = icon,
                contentDescription = label,
                tint = if (selected) Color.White else Color(0xFF14532D),
                modifier = Modifier.size(26.dp)
            )
            Text(
                text = label,
                color = if (selected) Color.White else Color(0xFF14532D),
                style = TextStyle(
                    fontFamily = pixelFont(),
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp
                )
            )
        }
    }
}

@Composable
private fun pixelFont(): FontFamily = FontFamily(Font(Res.font.press_start_2p_regular))