package com.example.pokedex.permission

import dev.icerock.moko.permissions.DeniedAlwaysException
import dev.icerock.moko.permissions.DeniedException
import dev.icerock.moko.permissions.PermissionState
import dev.icerock.moko.permissions.PermissionsController
import dev.icerock.moko.permissions.location.LOCATION
import dev.icerock.moko.permissions.Permission as MokoPermission

enum class AppPermission {
    LOCATION,
    CAMERA
}

enum class PermissionStatus {
    GRANTED,
    DENIED,
    NOT_DETERMINED,
    DENIED_ALWAYS
}

interface IPermissionManager {
    suspend fun request(
        vararg permissions: AppPermission,
        blockDenied: () -> Unit,
        blockDeniedAlways: () -> Unit,
        blockSuccess: (Map<AppPermission, PermissionStatus>) -> Unit
    )
    fun openSettings()
    val controller: PermissionsController
}

class PermissionManager(
    override val controller: PermissionsController
) : IPermissionManager {
    private fun AppPermission.toMoko(): MokoPermission = when (this) {
        AppPermission.LOCATION -> MokoPermission.LOCATION
        AppPermission.CAMERA -> error("CAMERA is not available in MOKO permissions v0.20.1")
    }

    private fun PermissionState.toPermissionStatus(): PermissionStatus = when (this) {
        PermissionState.Granted -> PermissionStatus.GRANTED
        PermissionState.NotGranted,
        PermissionState.Denied -> PermissionStatus.DENIED
        PermissionState.DeniedAlways -> PermissionStatus.DENIED_ALWAYS
        PermissionState.NotDetermined -> PermissionStatus.NOT_DETERMINED
    }

    override suspend fun request(
        vararg permissions: AppPermission,
        blockDenied: () -> Unit,
        blockDeniedAlways: () -> Unit,
        blockSuccess: (Map<AppPermission, PermissionStatus>) -> Unit
    ) {
        kotlin.runCatching {
            permissions.forEach {
                controller.providePermission(it.toMoko())
            }
            permissions.associateWith {
                controller.getPermissionState(it.toMoko()).toPermissionStatus()
            }
        }.onSuccess { result ->
            blockSuccess(result)
        }.onFailure { exception ->
            when (exception) {
                is DeniedAlwaysException -> blockDeniedAlways.invoke()
                is DeniedException -> blockDenied.invoke()
            }
        }
    }

    override fun openSettings() {
        controller.openAppSettings()
    }
}
