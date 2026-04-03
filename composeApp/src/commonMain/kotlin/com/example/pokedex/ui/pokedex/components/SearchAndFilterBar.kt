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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SearchAndFilterBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    types: List<String>,
    selectedType: String?,
    onTypeSelected: (String?) -> Unit
) {
    // Estado de expansão para a lista de filtros
    var isExpanded by remember { mutableStateOf(false) }

    // Ordena os tipos em ordem alfabética
    val sortedTypes = remember(types) {
        types.sortedBy { it.lowercase() }
    }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 4.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Barra de Pesquisa (Ocupa 70% da largura à esquerda)
            Surface(
                modifier = Modifier
                    .weight(0.75f) // Parte esquerda
                    .height(56.dp)
                    .shadow(2.dp, RoundedCornerShape(24.dp))
                    .border(1.dp, Color(0xFFD1E7D1), RoundedCornerShape(24.dp))
                    .clip(RoundedCornerShape(24.dp)),
                color = Color(0xFFF0F8F0) // Fundo padrão padronizado
            ) {
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = onSearchQueryChange,
                    placeholder = {
                        Text("Search Pokémon...", color = Color(0xFF8DB3A1))
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = Color(0xFF2D6A4F)
                        )
                    },
                    modifier = Modifier.fillMaxSize(),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                        cursorColor = Color(0xFF2D6A4F),
                        focusedTextColor = Color(0xFF2D6A4F),
                        unfocusedTextColor = Color(0xFF2D6A4F)
                    )
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            // Botão de Filtro apenas Ícone (Ocupa o restante 30% à direita)
            Surface(
                modifier = Modifier
                    .weight(0.25f) // Parte direita
                    .height(56.dp)
                    .shadow(2.dp, RoundedCornerShape(24.dp))
                    .border(1.dp, Color(0xFFD1E7D1), RoundedCornerShape(24.dp))
                    .clip(RoundedCornerShape(24.dp))
                    .clickable { isExpanded = !isExpanded }, // Alterna expansão
                color = Color(0xFFF0F8F0)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    // Ícone do filtro (centralizado)
                    Icon(
                        imageVector = Icons.Default.FilterList,
                        contentDescription = null,
                        tint = Color(0xFF2D6A4F),
                        modifier = Modifier.size(24.dp).align(Alignment.Center)
                    )

                    // Indicador de filtro ativo (bolinha no canto superior direito)
                    if (selectedType != null) {
                        Box(
                            modifier = Modifier
                                .padding(top = 10.dp, end = 10.dp)
                                .size(8.dp)
                                .background(Color(0xFF1B4332), CircleShape)
                                .align(Alignment.TopEnd)
                        )
                    }
                }
            }
        }

        // Painel de Filtro Expandido (lista vertical rolável abaixo)
        AnimatedVisibility(
            visible = isExpanded,
            enter = expandVertically(animationSpec = tween(400)) + fadeIn(animationSpec = tween(300)),
            exit = shrinkVertically(animationSpec = tween(400)) + fadeOut(animationSpec = tween(300))
        ) {
            Surface(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .height(200.dp) // Altura fixa para mostrar ~4 itens
                    .shadow(3.dp, RoundedCornerShape(24.dp))
                    .border(1.dp, Color(0xFFD1E7D1), RoundedCornerShape(24.dp)),
                color = Color(0xFFFBFBFB), // Fundo do painel
                shape = RoundedCornerShape(24.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.padding(12.dp),
                    contentPadding = PaddingValues(vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    // Item "All" sempre no topo
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
                    // Itens ordenados
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
            .padding(horizontal = 16.dp, vertical = 5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text.lowercase().replaceFirstChar { it.uppercase() }, // Força Capitalização
            color = if (isSelected) Color(0xFF1B4332) else Color(0xFF2D6A4F),
            fontSize = 14.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium
        )
        if (isSelected) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = null,
                tint = Color(0xFF1B4332),
                modifier = Modifier.size(20.dp)
            )
        }
    }
}