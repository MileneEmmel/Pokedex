package com.example.pokedex.ui.scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.ui.AppFonts
import com.example.pokedex.ui.ThemeColors

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
            .shadow(
                elevation = 20.dp,
                ambientColor = ThemeColors.scaffoldShadowLight.copy(alpha = 0.08f),
                spotColor = ThemeColors.scaffoldShadowStrong.copy(alpha = 0.2f),
                clip = false
            )
            .background(ThemeColors.scaffoldBackground.copy(alpha = 0.95f))
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
                    fontFamily = AppFonts.pixel(),
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



