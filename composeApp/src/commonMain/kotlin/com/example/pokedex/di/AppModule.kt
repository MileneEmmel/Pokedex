package com.example.pokedex.di

import com.example.pokedex.location.ILocationService
import com.example.pokedex.location.LocationService
import com.example.pokedex.location.LocationViewModel
import com.example.pokedex.permission.IPermissionManager
import com.example.pokedex.permission.PermissionFactory
import com.example.pokedex.permission.PermissionManager
import dev.icerock.moko.geo.LocationTracker
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.module

val locationModule = module {
    single<LocationTracker> {
        val permissionManager = get<IPermissionManager>()
        LocationTracker(permissionsController = permissionManager.controller)
    }
    single<ILocationService> { LocationService(get()) }
    viewModel { LocationViewModel(get(), get()) }
}

val permissionModule = module {
    single<IPermissionManager> {
        PermissionManager(
            controller = PermissionFactory()
                .getPermissionFactory()
                .createPermissionsController()
        )
    }
}
val appModules = listOf(permissionModule, locationModule)
fun initKoin() { org.koin.core.context.startKoin { modules(appModules) } }
