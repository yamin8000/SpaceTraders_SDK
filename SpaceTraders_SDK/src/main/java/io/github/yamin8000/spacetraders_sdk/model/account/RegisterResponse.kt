package io.github.yamin8000.spacetraders_sdk.model.account

import io.github.yamin8000.spacetraders_sdk.model.agent.Agent
import io.github.yamin8000.spacetraders_sdk.model.contract.Contract
import io.github.yamin8000.spacetraders_sdk.model.ship.Ship
import io.github.yamin8000.spacetraders_sdk.model.faction.Faction
import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponse(
    val agent: Agent,
    val contract: Contract,
    val faction: Faction,
    val ship: Ship,
    val token: String,
)