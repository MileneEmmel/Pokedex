package com.example.pokedex

import androidx.compose.ui.window.ComposeUIViewController

fun MainViewController() = ComposeUIViewController {
    App(databaseBuilder = com.example.pokedex.data.local.getDatabaseBuilder())
}