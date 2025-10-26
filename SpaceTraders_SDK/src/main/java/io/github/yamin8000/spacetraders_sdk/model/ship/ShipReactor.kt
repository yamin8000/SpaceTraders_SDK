package io.github.yamin8000.spacetraders_sdk.model.ship

import kotlinx.serialization.Serializable

@Serializable
data class ShipReactor(
    val symbol: ShipReactorSymbol,
    val name: String,
    val description: String,
    val condition: Condition? = null,
    val powerOutput: Int,
    val requirements: ShipRequirements
)
