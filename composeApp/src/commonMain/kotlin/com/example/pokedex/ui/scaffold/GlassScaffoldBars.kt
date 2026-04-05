package com.example.pokedex.ui.scaffold

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.ui.ThemeColors
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
            // Sombra moderna e difusa com spotColor levemente mais forte
            .shadow(
                elevation = 20.dp,
                ambientColor = ThemeColors.scaffoldShadowLight.copy(alpha = 0.08f),
                spotColor = ThemeColors.scaffoldShadowStrong.copy(alpha = 0.2f),
                clip = false
            )
            // 🔹 AJUSTE AQUI: Aumentado o alpha para 0.95f para ficar MENOS transparente
            .background(ThemeColors.scaffoldBackground.copy(alpha = 0.95f))
            // Linha sutil embaixo para simular o corte do vidro
            .drawBehind {
                drawLine(
                    color = Color.White.copy(alpha = 0.25f),
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 1.dp.toPx()
                )
            }
            .statusBarsPadding()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (showBack) {
                Box(
                    modifier = Modifier
                        .shadow(3.dp, CircleShape)
                        .background(ThemeColors.lightIceGreen, CircleShape)
                        .clip(CircleShape)
                        .clickable(onClick = onBackClick)
                        .padding(8.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Voltar",
                        tint = ThemeColors.deepGreen,
                        modifier = Modifier.size(24.dp)
                    )
                }
            } else {
                Spacer(modifier = Modifier.size(40.dp))
            }

            Text(
                text = title,
                color = ThemeColors.deepGreen,
                style = TextStyle(
                    fontFamily = pixelFont(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                ),
                maxLines = 1,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.size(40.dp))
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
    val shape = RoundedCornerShape(
        topStart = 24.dp,
        topEnd = 24.dp
    )

    val sharedGradient = Brush.linearGradient(
        listOf(
            ThemeColors.darkGreen,
            ThemeColors.mediumGreen
        )
    )

    Surface(
        // 🔹 AJUSTE AQUI: Aumentado o alpha para 0.95f para ficar MENOS transparente
        color = ThemeColors.scaffoldBackground.copy(alpha = 0.95f),
        shape = shape,
        modifier = modifier
            .fillMaxWidth()
            // Sombra difusa e profunda para aumentar a sensação tátil
            .shadow(
                elevation = 24.dp,
                shape = shape,
                spotColor = ThemeColors.scaffoldShadowStrong.copy(alpha = 0.25f),
                ambientColor = ThemeColors.scaffoldShadowLight.copy(alpha = 0.12f)
            )
            .drawBehind {
                val strokeWidth = 1.dp.toPx()
                drawLine(
                    color = Color.White.copy(alpha = 0.4f), // Borda superior iluminada mais nítida
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = strokeWidth * 2
                )
            }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            GlassBottomNavItem(
                label = "POKEDEX",
                icon = painterResource(Res.drawable.open_book),
                selected = isPokedexSelected,
                selectedBrush = sharedGradient,
                onClick = onPokedexClick,
                modifier = Modifier.weight(1f)
            )

            GlassBottomNavItem(
                label = "MY TEAM",
                icon = painterResource(Res.drawable.shield),
                selected = isTeamSelected,
                selectedBrush = sharedGradient,
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
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val shape = RoundedCornerShape(16.dp)
    val scale by animateFloatAsState(if (selected) 1.05f else 1f)

    Box(
        modifier = modifier
            .scale(scale)
            .shadow(
                elevation = if (selected) 15.dp else 0.dp,
                shape = shape,
                ambientColor = ThemeColors.scaffoldShadowStrong,
                spotColor = ThemeColors.scaffoldShadowStrong
            )
            .background(
                color = if (selected) androidx.compose.ui.graphics.Color.Transparent
                // 🔹 AJUSTE AQUI: Aumentado o alpha do item inativo para 0.7f
                else ThemeColors.scaffoldItemBackground.copy(alpha = 0.7f),
                shape = shape
            )
            .background(
                brush = if (selected) selectedBrush else Brush.verticalGradient(listOf(
                    androidx.compose.ui.graphics.Color.Transparent,
                    androidx.compose.ui.graphics.Color.Transparent
                )),
                shape = shape
            )
            .border(
                width = 1.dp,
                // 🔹 AJUSTE AQUI: Aumentado o alpha da borda inativa para 0.4f
                color = if (selected)
                    ThemeColors.scaffoldBorderSelected
                else
                    ThemeColors.scaffoldBorderUnselected.copy(alpha = 0.4f),
                shape = shape
            )
            .clip(shape)
            .clickable(onClick = onClick)
            .padding(vertical = 12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Icon(
                painter = icon,
                contentDescription = label,
                tint = if (selected)
                    Color.White
                else
                    ThemeColors.deepGreen,
                modifier = Modifier.size(26.dp)
            )

            Text(
                text = label,
                color = if (selected)
                    Color.White
                else
                    ThemeColors.deepGreen,
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
private fun pixelFont(): FontFamily =
    FontFamily(Font(Res.font.press_start_2p_regular))