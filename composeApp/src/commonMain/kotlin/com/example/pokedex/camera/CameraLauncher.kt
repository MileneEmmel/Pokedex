package com.example.pokedex.camera

import androidx.compose.runtime.Composable

// Abre a câmera nativa da plataforma (gerencia permissão internamente) e devolve
// o caminho do arquivo da foto capturada, ou null se cancelada / sem permissão
@Composable
expect fun rememberCameraLauncher(onResult: (String?) -> Unit): () -> Unit
