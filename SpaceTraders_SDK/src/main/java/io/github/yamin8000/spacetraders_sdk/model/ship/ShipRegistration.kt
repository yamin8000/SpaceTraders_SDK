package io.github.yamin8000.spacetraders_sdk.model.ship

import io.github.yamin8000.spacetraders_sdk.model.faction.FactionSymbol
import kotlinx.serialization.Serializable

@Serializable
data class ShipRegistration(
    val name: String,
    val factionSymbol: FactionSymbol,
    val role: ShipRole
)
