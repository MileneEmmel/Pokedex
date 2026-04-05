package com.example.pokedex.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

object AppFonts {
    @Composable
    fun pixel(): FontFamily = FontFamily(Font(Res.font.press_start_2p_regular))
}

