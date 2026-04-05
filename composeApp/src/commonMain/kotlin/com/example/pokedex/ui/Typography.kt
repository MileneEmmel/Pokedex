package com.example.pokedex.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object Typography {

    @Composable
    fun pixelCounter(): TextStyle = TextStyle(
        fontFamily    = AppFonts.pixel(),
        fontWeight    = FontWeight.ExtraBold,
        fontSize      = 14.sp,
        letterSpacing = 1.sp
    )

    @Composable
    fun statValue(): TextStyle = TextStyle(
        fontFamily    = AppFonts.pixel(),
        fontWeight    = FontWeight.ExtraBold,
        fontSize      = 30.sp,
        letterSpacing = 0.4.sp
    )

    @Composable
    fun pixelGridItem(): TextStyle = TextStyle(
        fontFamily = AppFonts.pixel(),
        fontSize   = 9.sp
    )

    @Composable
    fun pixelCardTitle(): TextStyle = TextStyle(
        fontFamily = AppFonts.pixel(),
        fontSize   = 12.sp
    )

    @Composable
    fun pixelAbility(): TextStyle = TextStyle(
        fontFamily = AppFonts.pixel(),
        fontSize   = 11.sp
    )

    @Composable
    fun pixelId(): TextStyle = TextStyle(
        fontFamily = AppFonts.pixel(),
        fontSize   = 10.sp
    )

    val cardTitle = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize   = 33.sp
    )

    val placeHolder = TextStyle(
        fontSize = 16.sp
    )

    val filterItemRegular = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize   = 14.sp
    )

    val filterItemBold = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize   = 14.sp
    )

    val gridItemName = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize   = 16.sp
    )

    val descriptionText = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize   = 14.sp,
        lineHeight = 22.sp
    )

    val infoValue = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize   = 16.sp
    )

    val genderLabel = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize   = 14.sp
    )

    val pokemonCardName = TextStyle(
        fontWeight = FontWeight.ExtraBold,
        fontSize   = 24.sp
    )
}