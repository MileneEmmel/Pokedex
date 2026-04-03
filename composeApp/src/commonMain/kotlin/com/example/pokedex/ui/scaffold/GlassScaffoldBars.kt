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
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

@Composable
fun GlassTopBar(
    title: String,
    showBack: Boolean,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // TopBar translúcida ajustada para o tom "verde clarinho quase branco" (bg-white/60 no React)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White.copy(alpha = 0.60f)) // Fundo translúcido
            .border(BorderStroke(1.dp, GlassScaffoldTokens.barBorder))
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
                        .background(Color.White.copy(alpha = 0.60f), backShape)
                        .border(1.dp, Color.White.copy(alpha = 0.70f), backShape)
                        .clip(backShape)
                        .clickable(onClick = onBackClick)
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Back",
                        color = Color(0xFF14532D),
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
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
    pokedexIcon: Painter,
    teamIcon: Painter,
    onPokedexClick: () -> Unit,
    onTeamClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val bottomShape = RoundedCornerShape(
        topStart = GlassScaffoldTokens.bottomBarCorner,
        topEnd = GlassScaffoldTokens.bottomBarCorner
    )

    // Fundo da barra inferior ajustado para o tom "verde clarinho quase branco" (bg-white/60 no React)
    Surface(
        color = Color.White.copy(alpha = 0.60f),
        shape = bottomShape,
        shadowElevation = 16.dp, // Sombra forte (shadow-2xl)
        modifier = modifier
            .fillMaxWidth()
            // Borda superior (border-t-3)
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                val y = strokeWidth / 2
                drawLine(
                    color = GlassScaffoldTokens.barBorder,
                    start = Offset(0f, y),
                    end = Offset(size.width, y),
                    strokeWidth = strokeWidth * 2
                )
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            GlassBottomNavItem(
                label = "POKEDEX",
                icon = pokedexIcon,
                selected = isPokedexSelected,
                selectedBrush = GlassScaffoldTokens.pokedexSelectedGradient,
                shadowColor = GlassScaffoldTokens.pokedexShadowColor,
                onClick = onPokedexClick,
                modifier = Modifier.weight(1f)
            )

            GlassBottomNavItem(
                label = "MY TEAM",
                icon = teamIcon,
                selected = isTeamSelected,
                selectedBrush = GlassScaffoldTokens.teamSelectedGradient,
                shadowColor = GlassScaffoldTokens.teamShadowColor,
                onClick = onTeamClick,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
private fun GlassBottomNavItem(
    label: String,
    icon: Painter, // Voltamos para Painter
    selected: Boolean,
    selectedBrush: Brush,
    shadowColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(GlassScaffoldTokens.tabCorner)
    // Animação de escala (scale-105)
    val scale by animateFloatAsState(if (selected) 1.05f else 1f)

    Box(
        modifier = modifier
            .scale(scale)
            // Sombra colorida no item selecionado (shadow-lg)
            .then(
                if (selected) Modifier.shadow(
                    elevation = 12.dp,
                    shape = shape,
                    ambientColor = shadowColor,
                    spotColor = shadowColor
                ) else Modifier
            )
            .background(
                // Cor de fundo do item inativo (bg-white/40)
                color = if (selected) Color.Transparent else GlassScaffoldTokens.inactiveTabBackground,
                shape = shape
            )
            .background(
                brush = if (selected) selectedBrush else Brush.verticalGradient(
                    listOf(
                        Color.Transparent,
                        Color.Transparent
                    )
                ),
                shape = shape
            )
            // Borda do item (border-white/50 ou border-white/60 no React)
            .border(
                width = 1.dp,
                color = if (selected) Color.White.copy(alpha = 0.50f) else GlassScaffoldTokens.inactiveTabBorder,
                shape = shape
            )
            .clip(shape)
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp), // py-3
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Icon(
                painter = icon,
                contentDescription = label,
                // Cores do texto/ícone: Branco se selecionado, Verde escuro se inativo (text-white vs text-green-800)
                tint = if (selected) Color.White else Color(0xFF166534),
                modifier = Modifier.size(24.dp) // w-6
            )
            Text(
                text = label,
                color = if (selected) Color.White else Color(0xFF166534),
                style = TextStyle(
                    fontFamily = pixelFont(),
                    fontWeight = FontWeight.Medium,
                    fontSize = 11.sp // text-xs
                )
            )
        }
    }
}

@Composable
private fun pixelFont(): FontFamily = FontFamily(Font(Res.font.press_start_2p_regular))