package io.github.yamin8000.spacetraders_sdk.model.ship

import kotlinx.serialization.Serializable

@Serializable
data class ShipCrew(
    val current: Int,
    val capacity: Int,
    val required: Int,
    val rotation: ShipCrewRotation = ShipCrewRotation.STRICT,
    val morale: Int,
    val wages: Int
)
