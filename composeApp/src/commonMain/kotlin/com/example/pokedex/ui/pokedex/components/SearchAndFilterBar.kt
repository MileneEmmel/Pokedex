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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedex.ui.ThemeColors
import com.example.pokedex.ui.Typography

@Composable
fun SearchAndFilterBar(
    searchQuery: String,                   // Texto atual no campo de busca
    onSearchQueryChange: (String) -> Unit, // Flag disparada quando o texto é alterado
    types: List<String>,                   // Lista com todos os tipos de Pokemons
    selectedType: String?,                 // Tipo selecionado (null = Todos)
    onTypeSelected: (String?) -> Unit      // Flag disparada quando o filtro é alterado
) {
    // Controla se o painel expansível de filtros está visível (true) ou oculto (false)
    var isExpanded by remember { mutableStateOf(false) }

    val shape = RoundedCornerShape(24.dp)

    // Ordena a lista de tipos em ordem alfabética
    val sortedTypes = remember(types) { types.sortedBy { it.lowercase() } }

    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp, vertical = 2.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Campo de busca com ícone
            ElevatedCard(
                modifier = Modifier
                    .weight(0.75f) // Ocupa 75% da linha
                    .height(56.dp)
                    .border(1.dp, Color.White, shape),
                shape = shape,
                colors = CardDefaults.elevatedCardColors(containerColor = ThemeColors.lightIceGreen),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp)
            ) {
                OutlinedTextField(
                    value         = searchQuery,         // Texto atual no campo de busca
                    onValueChange = onSearchQueryChange, // Flag disparada quando o texto é alterado
                    placeholder   = {
                        Text(
                            text  = "Search Pokémon...",
                            color = ThemeColors.deepGreen.copy(alpha = 0.5f),
                            style = Typography.placeHolder
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector        = Icons.Default.Search,
                            contentDescription = null,
                            tint               = ThemeColors.deepGreen
                        )
                    },
                    modifier   = Modifier.fillMaxSize(),
                    singleLine = true,
                    colors     = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor   = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        focusedBorderColor      = Color.Transparent,
                        unfocusedBorderColor    = Color.Transparent,
                        cursorColor             = ThemeColors.deepGreen,
                        focusedTextColor        = ThemeColors.deepGreen,
                        unfocusedTextColor      = ThemeColors.deepGreen
                    ),
                    textStyle = Typography.placeHolder
                )
            }

            // Botão de filtro com indicador de seleção ativa
            ElevatedCard(
                modifier = Modifier
                    .weight(0.25f) // Ocupa 25% restante da linha
                    .height(56.dp)
                    .clip(shape)
                    .border(1.dp, Color.White, shape)
                    .clickable { isExpanded = !isExpanded },
                shape     = shape,
                colors    = CardDefaults.elevatedCardColors(containerColor = ThemeColors.lightIceGreen),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp)
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    // Ícone do botão de filtro
                    Icon(
                        imageVector        = Icons.Default.FilterList,
                        contentDescription = null,
                        tint               = ThemeColors.deepGreen,
                        modifier           = Modifier.size(24.dp).align(Alignment.Center)
                    )

                    // Indicador se algum filtro estiver ativo
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

        // Painel expansível com a lista de tipos
        AnimatedVisibility(
            visible = isExpanded,
            // Abre o fltro de cima para baixo
            enter   = expandVertically(tween(300)) + fadeIn(),
            // Fecha o filtro com movimento inverso
            exit    = shrinkVertically(tween(300)) + fadeOut()
        ) {
            ElevatedCard(
                modifier = Modifier
                    .padding(top = 8.dp)
                    .fillMaxWidth()
                    .height(200.dp)
                    .border(1.dp, Color.White, shape),
                shape     = shape,
                colors    = CardDefaults.elevatedCardColors(containerColor = ThemeColors.lightIceGreen),
                elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp)
            ) {

                LazyColumn( // Lista de rolagem das opções do filtro
                    modifier            = Modifier.padding(12.dp),
                    verticalArrangement = Arrangement.spacedBy(3.dp)
                ) {

                    // Primeira opção "All", limpa o filtro
                    item {
                        FilterListItem(
                            text       = "All",
                            isSelected = selectedType == null,
                            onClick    = {
                                onTypeSelected(null)
                                isExpanded = false
                            }
                        )
                    }

                    // Lista todos os tipos, filtra pelo tipo escolhido
                    items(sortedTypes) { type -> FilterListItem(
                            text       = type,
                            isSelected = selectedType == type,
                            onClick    = {
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

@Composable
fun FilterListItem(text: String, isSelected: Boolean, onClick: () -> Unit) {
    // Layout em linha com click habilitado para a linha toda
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        // Nome do tipo
        Text(
            text  = text.replaceFirstChar { it.uppercase() }, // Primeira letra maiúscula
            color = ThemeColors.deepGreen,
            // Negrito para tipo selecionado
            style = if (isSelected) Typography.filterItemBold else Typography.filterItemRegular
        )

        // Ícone de 'check' no tipo selecionado
        if (isSelected) {
            Icon(
                imageVector        = Icons.Default.Check,
                contentDescription = null,
                tint               = ThemeColors.deepGreen,
                modifier           = Modifier.size(20.dp)
            )
        }
    }
}