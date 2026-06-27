package com.example.pokedex.permission

import android.content.Context
import dev.icerock.moko.permissions.PermissionsController
import dev.icerock.moko.permissions.compose.PermissionsControllerFactory
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

actual class PermissionFactory actual constructor() : KoinComponent {
    private val context: Context by inject()

    actual fun getPermissionFactory() : PermissionsControllerFactory =
        PermissionsControllerFactory {
            PermissionsController(applicationContext = context)
        }
}
