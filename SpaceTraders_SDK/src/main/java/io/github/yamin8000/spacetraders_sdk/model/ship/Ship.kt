package io.github.yamin8000.spacetraders_sdk.model.ship

import kotlinx.serialization.Serializable

@Serializable
data class Ship(
    val symbol: String,
    val registration: ShipRegistration,
    val nav: ShipNav,
    val crew: ShipCrew,
    val frame: ShipFrame,
    val reactor: ShipReactor,
    val engine: ShipEngine,
    val cooldown: ShipCooldown,
    val modules: List<ShipModule>,
    val mounts: List<ShipMount>,
    val cargo: ShipCargo,
    val fuel: ShipFuel,
)
