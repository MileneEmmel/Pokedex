package com.example.pokedex.ui.team
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.pokedex.data.Pokemon
import com.example.pokedex.ui.Typography
import com.example.pokedex.ui.MiniStat
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.capitalizePokemonName
import com.example.pokedex.ui.formatPokemonNumber
import com.example.pokedex.ui.getStatAbbreviation
import com.example.pokedex.ui.getStatColor
import com.example.pokedex.ui.getTypeColor
import kotlin.math.abs
@Composable
fun TeamMemberCard(
    pokemon: Pokemon,
    modifier: Modifier = Modifier,
    onViewDetailsClick: () -> Unit = {},
    onRemoveClick: () -> Unit = {}
) {
    var offsetX by remember(pokemon.id) { mutableFloatStateOf(0f) }
    val removeThresholdPx = with(LocalDensity.current) { 120.dp.toPx() }
    val swipeProgress = (abs(offsetX) / removeThresholdPx).coerceIn(0f, 1f)
    ElevatedCard(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = if (swipeProgress > 0f) {
                Color(0xFFDC2626).copy(alpha = 0.18f + (0.22f * swipeProgress))
            } else {
                Color.White.copy(alpha = 0.30f)
            }
        ),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 0.dp),
        modifier = modifier
            .fillMaxWidth()
            .border(3.dp, Color.White.copy(alpha = 0.50f), RoundedCornerShape(24.dp))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .pointerInput(pokemon.id) {
                    detectHorizontalDragGestures(
                        onHorizontalDrag = { _, dragAmount ->
                            offsetX += dragAmount
                        },
                        onDragEnd = {
                            if (abs(offsetX) > removeThresholdPx) {
                                onRemoveClick()
                            } else {
                                offsetX = 0f
                            }
                        },
                        onDragCancel = { offsetX = 0f }
                    )
                }
        ) {
            if (swipeProgress > 0f) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = "Delete",
                    tint = Color.White.copy(alpha = swipeProgress),
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .padding(end = 22.dp)
                        .size(30.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .graphicsLayer { translationX = offsetX }
            ) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(100.dp)
                                .clip(RoundedCornerShape(20.dp))
                                .background(
                                    Brush.linearGradient(
                                        listOf(
                                            Color(0xFFDCFCE7).copy(alpha = 0.60f),
                                            Color(0xFFA7F3D0).copy(alpha = 0.60f)
                                        )
                                    )
                                )
                                .border(2.dp, Color.White.copy(alpha = 0.50f), RoundedCornerShape(20.dp)),
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                model = pokemon.imageUrl,
                                contentDescription = pokemon.name,
                                modifier = Modifier.size(80.dp)
                            )
                            Text(
                                text = pokemon.id.formatPokemonNumber(),
                                color = Color(0xFF14532D),
                                style = Typography.statValue(),
                                fontSize = 10.sp,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier
                                    .align(Alignment.TopCenter)
                                    .padding(top = 6.dp)
                            )
                        }
                        Column(
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text(
                                text = pokemon.name.capitalizePokemonName(),
                                color = Color(0xFF064E3B),
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.ExtraBold,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                                pokemon.types.take(2).forEach { type ->
                                    val typeColor = getTypeColor(type)
                                    Surface(
                                        shape = RoundedCornerShape(6.dp),
                                        color = typeColor,
                                        border = androidx.compose.foundation.BorderStroke(
                                            1.dp,
                                            Color.White.copy(alpha = 0.80f)
                                        )
                                    ) {
                                        Text(
                                            text = type.capitalizePokemonName(),
                                            color = Color.White,
                                            style = MaterialTheme.typography.labelSmall,
                                            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp),
                                            fontSize = 10.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                listOf("hp", "attack", "defense", "speed").forEach { statName ->
                                    MiniStat(
                                        label = getStatAbbreviation(statName),
                                        value = pokemon.stats.firstOrNull { it.name == statName }?.value ?: 0,
                                        valueColor = getStatColor(statName),
                                        bgColor = Color(0xFF14532D).copy(alpha = 0.15f),
                                        borderColor = getStatColor(statName).copy(alpha = 0.2f)
                                    )
                                }
                            }
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFF16A34A).copy(alpha = 0.72f))
                            .border(1.dp, ThemeColors.borderMediumGreen)
                            .clickable(onClick = onViewDetailsClick)
                            .padding(vertical = 20.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "VIEW DETAILS",
                            color = Color.White,
                            style = Typography.statValue(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            letterSpacing = 1.sp
                        )
                    }
                }
            }
        }
    }
}
