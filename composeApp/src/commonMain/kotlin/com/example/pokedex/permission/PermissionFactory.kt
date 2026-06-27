package com.example.pokedex.permission

import dev.icerock.moko.permissions.compose.PermissionsControllerFactory

expect class PermissionFactory() {
    fun getPermissionFactory(): PermissionsControllerFactory
}
