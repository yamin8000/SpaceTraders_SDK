package io.github.yamin8000.spacetraders_sdk.model.ship

import kotlinx.serialization.Serializable

@Serializable
data class Shipyard(
    val symbol: String,
    val shipTypes: List<ShipType>,
    val transactions: List<ShipyardTransaction>? = null,
    val ships: List<ShipyardShip>?
)
