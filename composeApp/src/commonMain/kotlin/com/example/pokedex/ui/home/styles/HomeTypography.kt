package com.example.pokedex.ui

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.Font
import pokedex.composeapp.generated.resources.Res
import pokedex.composeapp.generated.resources.press_start_2p_regular

object HomeTypography {
    @Composable
    private fun pressStart2P(): FontFamily = FontFamily(Font(Res.font.press_start_2p_regular))

    @Composable
    fun title(): TextStyle = TextStyle(
        fontFamily = pressStart2P(),
        fontWeight = FontWeight.Black,
        fontSize = 44.sp,
        letterSpacing = 0.8.sp
    )

    @Composable
    fun statValue(): TextStyle = TextStyle(
        fontFamily = pressStart2P(),
        fontWeight = FontWeight.ExtraBold,
        fontSize = 30.sp,
        letterSpacing = 0.4.sp
    )

    val cardTitle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 33.sp
    )
}




