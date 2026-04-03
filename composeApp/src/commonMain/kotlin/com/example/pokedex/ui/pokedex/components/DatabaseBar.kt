package com.example.pokedex.ui.pokedex.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

@Composable
fun DatabaseBar(currentCount: Int, totalCount: Int) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 2.dp)
            .height(56.dp)
            .shadow(2.dp, RoundedCornerShape(24.dp))
            .border(1.dp, Color(0xFFD1E7D1), RoundedCornerShape(24.dp))
            .clip(RoundedCornerShape(24.dp)),
        color = Color(0xFFF0F8F0)
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Database",
                color = Color(0xFF2D6A4F),
                fontSize = 18.sp,
            )

            Text(
                text = "$currentCount/$totalCount",
                color = Color(0xFF1B4332),
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily(Font(Res.font.press_start_2p_regular)),
                letterSpacing = 1.sp
            )
        }
    }
}
