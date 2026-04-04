package com.example.pokedex.ui.pokedex.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedex.ui.ThemeColors

@Composable
fun SearchAndFilterBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    types: List<String>,
    selectedType: String?,
    onTypeSelected: (String?) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    val shape = RoundedCornerShape(24.dp)

    val sortedTypes = remember(types) {
        types.sortedBy { it.lowercase() }
    }

    Column(modifier = Modifier.fillMaxWidth()) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // 🔍 SEARCH BAR
            Surface(
                modifier = Modifier
                    .weight(0.75f)
                    .height(56.dp)
                    .border(1.dp, Color.White, shape),
                shape = shape,
                color = ThemeColors.lightIceGreen,
                shadowElevation = 6.dp,
                tonalElevation = 2.dp
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = onSearchQueryChange,
                    placeholder = {
                        Text(
                            "Search Pokémon...",
                            color = ThemeColors.deepGreen.copy(alpha = 0.5f)
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = ThemeColors.deepGreen
                        )
                    },
                    modifier = Modifier.fillMaxSize(),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        cursorColor = ThemeColors.deepGreen,
                        focusedTextColor = ThemeColors.deepGreen,
                        unfocusedTextColor = ThemeColors.deepGreen
                    )
                )
            }

            // 🎛️ FILTER BUTTON
            Surface(
                modifier = Modifier
                    .weight(0.25f)
                    .height(56.dp)
                    .border(1.dp, Color.White, shape)
                    .clickable { isExpanded = !isExpanded },
                shape = shape,
                color = ThemeColors.lightIceGreen,
                shadowElevation = 6.dp,
                tonalElevation = 2.dp
            ) {
                Box(modifier = Modifier.fillMaxSize()) {

                    Icon(
                        imageVector = Icons.Default.FilterList,
                        contentDescription = null,
                        tint = ThemeColors.deepGreen,
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center)
                    )

                    if (selectedType != null) {
                        Box(
                            modifier = Modifier
                                .padding(10.dp)
                                .size(8.dp)
                                .background(ThemeColors.deepGreen, CircleShape)
                                .align(Alignment.TopEnd)
                        )
                    }
                }
            }
        }

        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically(tween(300)) + fadeIn(),
            exit = shrinkVertically(tween(300)) + fadeOut()
        ) {
            Surface(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .height(200.dp)
                    .border(1.dp, Color.White, shape),
                shape = shape,
                color = ThemeColors.lightIceGreen,
                shadowElevation = 6.dp,
                tonalElevation = 2.dp
            ) {

                LazyColumn(
                    modifier = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(3.dp)
                ) {

                    item {
                        FilterListItem(
                            text = "All",
                            isSelected = selectedType == null,
                            onClick = {
                                onTypeSelected(null)
                                isExpanded = false
                            }
                        )
                    }

                    items(sortedTypes) { type ->
                        FilterListItem(
                            text = type,
                            isSelected = selectedType == type,
                            onClick = {
                                onTypeSelected(type)
                                isExpanded = false
                            }
                        )
                    }
                }
            }
        }
    }
}

// Item de lista estilizado para o painel expandido
@Composable
fun FilterListItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = text.replaceFirstChar { it.uppercase() },
            color = ThemeColors.deepGreen,
            fontSize = 14.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
        )

        if (isSelected) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = ThemeColors.deepGreen,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}