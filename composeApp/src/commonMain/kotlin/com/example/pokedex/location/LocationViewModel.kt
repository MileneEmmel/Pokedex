package com.example.pokedex.location

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.permission.AppPermission
import com.example.pokedex.permission.IPermissionManager
import com.example.pokedex.permission.PermissionStatus
import dev.icerock.moko.geo.LatLng
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.PermissionState
import dev.icerock.moko.permissions.location.LOCATION
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LocationViewModel(
    private val permissionManager: IPermissionManager,
    private val locationService: ILocationService
) : ViewModel() {

    val controller = permissionManager.controller
    val locationTracker = locationService.tracker

    private val _locationState = MutableStateFlow<LatLng?>(null)
    val locationState: StateFlow<LatLng?> = _locationState.asStateFlow()

    private val _permissionStatus = MutableStateFlow(PermissionStatus.NOT_DETERMINED)
    val permissionStatus: StateFlow<PermissionStatus> = _permissionStatus.asStateFlow()

    private val _isLoadingLocation = MutableStateFlow(false)
    val isLoadingLocation: StateFlow<Boolean> = _isLoadingLocation.asStateFlow()

    private var isObserving = false

    init {
        checkPermissionStatus(Permission.LOCATION) { status ->
            _permissionStatus.value = status
        }
    }

    private fun checkPermissionStatus(permission: Permission, onResult: (PermissionStatus) -> Unit) {
        viewModelScope.launch {
            try {
                val status = controller.getPermissionState(permission)
                onResult(status.toPermissionStatus())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun PermissionState.toPermissionStatus(): PermissionStatus = when (this) {
        PermissionState.Granted -> PermissionStatus.GRANTED
        PermissionState.DeniedAlways -> PermissionStatus.DENIED_ALWAYS
        else -> PermissionStatus.NOT_DETERMINED
    }

    private fun startLocationTracking() {
        _isLoadingLocation.value = true
        observeLocations()
        startTracking()
    }

    fun requestLocationPermission() {
        if (_permissionStatus.value == PermissionStatus.GRANTED) {
            startLocationTracking()
        } else {
            _isLoadingLocation.value = true
            viewModelScope.launch {
                permissionManager.request(
                    AppPermission.LOCATION,
                    blockDenied = {
                        _permissionStatus.value = PermissionStatus.DENIED
                        _isLoadingLocation.value = false
                    },
                    blockDeniedAlways = {
                        _permissionStatus.value = PermissionStatus.DENIED_ALWAYS
                        _isLoadingLocation.value = false
                    },
                    blockSuccess = { statuses ->
                        val status = statuses[AppPermission.LOCATION] ?: PermissionStatus.DENIED
                        _permissionStatus.value = status
                        if (status == PermissionStatus.GRANTED) {
                            startLocationTracking()
                        } else {
                            _isLoadingLocation.value = false
                        }
                    }
                )
            }
        }
    }

    fun openSettings() {
        permissionManager.openSettings()
    }

    private fun startTracking() {
        viewModelScope.launch {
            try {
                locationService.startTracking()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun observeLocations() {
        if (isObserving) return
        isObserving = true
        viewModelScope.launch {
            locationService.locations.collect { latLng ->
                _locationState.value = latLng
                _isLoadingLocation.value = false
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        locationService.stopTracking()
    }
}
