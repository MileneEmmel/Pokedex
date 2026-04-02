package com.example.pokedex.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HeaderSection(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PokeballBadge()

        Text(
            text = "POKÉDEX",
            color = Color.White,
            style = HomeTypography.title(),
            modifier = Modifier.padding(top = 16.dp)
        )

        Text(
            text = "Capture, Discover, Build Your Dream Team!",
            color = Color.White.copy(alpha = 0.92f),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
private fun PokeballBadge() {
    Surface(
        shape = CircleShape,
        color = Color.White.copy(alpha = 0.20f),
        modifier = Modifier
            .size(112.dp)
            .border(2.dp, HomeStyleTokens.cardBorder, CircleShape)
    ) {
        Box(contentAlignment = Alignment.Center) {
            Surface(
                shape = CircleShape,
                color = Color.White,
                modifier = Modifier
                    .size(66.dp)
                    .border(3.dp, Color(0xFF1F2937), CircleShape)
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color(0xFFDC2626))
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .background(Color(0xFFF8FAFC))
                    )
                }
            }

            Box(
                modifier = Modifier
                    .width(66.dp)
                    .height(4.dp)
                    .background(Color(0xFF111827))
            )

            Surface(
                shape = CircleShape,
                color = Color.White,
                modifier = Modifier
                    .size(18.dp)
                    .border(2.dp, Color(0xFF111827), CircleShape)
            ) {}
        }
    }
}





