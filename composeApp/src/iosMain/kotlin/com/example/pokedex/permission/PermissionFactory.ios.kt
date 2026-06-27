package com.example.pokedex.permission

import dev.icerock.moko.permissions.compose.PermissionsControllerFactory
import dev.icerock.moko.permissions.ios.PermissionsController

actual class PermissionFactory actual constructor() {
    actual fun getPermissionFactory(): PermissionsControllerFactory {
        return PermissionsControllerFactory{
            PermissionsController()
        }
    }
}
