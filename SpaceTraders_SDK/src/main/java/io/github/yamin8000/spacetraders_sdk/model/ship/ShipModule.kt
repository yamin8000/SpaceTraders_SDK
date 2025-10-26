package io.github.yamin8000.spacetraders_sdk.model.ship

import kotlinx.serialization.Serializable

/**
 * A module can be installed in a ship and provides a set of capabilities
 * such as storage space or quarters for crew. Module installations are
 * permanent.
 */
@Serializable
data class ShipModule(
    val symbol: ShipModuleSymbol,
    val name: String,
    val description: String,
    val capacity: Int? = null,
    val requirements: ShipRequirements,
    val range: Int? = null
)
