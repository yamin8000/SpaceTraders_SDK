package io.github.yamin8000.spacetraders_sdk.model.account

import io.github.yamin8000.spacetraders_sdk.model.faction.FactionSymbol
import kotlinx.serialization.Serializable

/** [symbol] ^[a-zA-Z0-9-_]+$, min:3, max:14, [faction] see [FactionSymbol], */
@Serializable
data class RegisterRequest(
    val faction: FactionSymbol,
    val symbol: String
)
