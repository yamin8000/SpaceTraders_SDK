package io.github.yamin8000.spacetraders_sdk.model.ship

import io.github.yamin8000.spacetraders_sdk.model.utils.InstantSerializer
import java.time.Instant
import kotlinx.serialization.Serializable

@Serializable
data class ShipNavRoute (
    val origin: ShipNavRouteWaypoint,
    val destination: ShipNavRouteWaypoint,
    @Serializable(with = InstantSerializer::class)
    val arrival: Instant,
    @Serializable(with = InstantSerializer::class)
    val departureTime: Instant
)