package com.example.pokedex.ui.scaffold

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.ui.AppFonts
import com.example.pokedex.ui.ThemeColors

@Composable
fun GlassBottomNavItem(
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
                color = if (selected) Color.Transparent else ThemeColors.scaffoldItemBackground.copy(alpha = 0.7f),
                shape = shape
            )
            .background(
                brush = if (selected) selectedBrush else Brush.verticalGradient(
                    listOf(Color.Transparent, Color.Transparent)
                ),
                shape = shape
            )
            .border(
                width = 1.dp,
                color = if (selected) ThemeColors.scaffoldBorderSelected
                else ThemeColors.scaffoldBorderUnselected.copy(alpha = 0.4f),
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
                tint = if (selected) Color.White else ThemeColors.deepGreen,
                modifier = Modifier.size(26.dp)
            )

            Text(
                text = label,
                color = if (selected) Color.White else ThemeColors.deepGreen,
                style = TextStyle(
                    fontFamily = AppFonts.pixel(),
                    fontWeight = FontWeight.Medium,
                    fontSize = 10.sp
                )
            )
        }
    }
}


