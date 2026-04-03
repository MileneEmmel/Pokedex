package com.example.pokedex.ui.team

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pokedex.ui.HomeTypography

@Composable
fun TeamHeaderSection(
    title: String,
    subtitle: String,
    titleColor: Color,
    subtitleColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = title,
            color = titleColor,
            style = HomeTypography.statValue(),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        if (subtitle.isNotBlank()) {
            Text(
                text = subtitle,
                color = subtitleColor,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
    }
}



