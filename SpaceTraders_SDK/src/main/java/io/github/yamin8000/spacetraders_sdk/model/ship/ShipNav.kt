package io.github.yamin8000.spacetraders_sdk.model.ship

import kotlinx.serialization.Serializable

@Serializable
data class ShipNav(
    val systemSymbol: String,
    val waypointSymbol: String,
    val route: ShipNavRoute,
    val status: ShipNavStatus,
    val flightMode: ShipNavFlightMode = ShipNavFlightMode.CRUISE
)