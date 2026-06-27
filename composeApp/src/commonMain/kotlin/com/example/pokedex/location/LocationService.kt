package com.example.pokedex.location

import dev.icerock.moko.geo.LatLng
import dev.icerock.moko.geo.LocationTracker
import kotlinx.coroutines.flow.Flow

interface ILocationService {
    val locations: Flow<LatLng>
    val tracker: LocationTracker
    suspend fun startTracking()
    fun stopTracking()
}

class LocationService(
    override val tracker: LocationTracker
) : ILocationService {
    override val locations: Flow<LatLng> = tracker.getLocationsFlow()

    override suspend fun startTracking() {
        tracker.startTracking()
    }

    override fun stopTracking() {
        tracker.stopTracking()
    }
}
