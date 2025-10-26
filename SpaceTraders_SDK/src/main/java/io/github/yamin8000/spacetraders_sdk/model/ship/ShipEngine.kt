package io.github.yamin8000.spacetraders_sdk.model.ship

import kotlinx.serialization.Serializable

@Serializable
data class ShipEngine(
    val symbol: ShipEngineSymbol,
    val name: String,
    val description: String,
    val integrity: ShipIntegrity,
    val condition: ShipCondition,
    val speed: Int,
    val requirements: ShipRequirements,
    val quality: Int
)
