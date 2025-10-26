package io.github.yamin8000.spacetraders_sdk.model.agent

import io.github.yamin8000.spacetraders_sdk.model.faction.FactionSymbol
import kotlinx.serialization.Serializable

@Serializable
data class Agent(
    val accountId: String? = null,
    val symbol: String,
    val headquarters: String,
    val credits: Long,
    val startingFaction: FactionSymbol,
    val shipCount: Int,
)