package io.github.yamin8000.spacetraders_sdk.model.agent

import io.github.yamin8000.spacetraders_sdk.model.utils.InstantSerializer
import kotlinx.serialization.Serializable
import java.time.Instant

data class AgentEvent(
    val id: String,
    val type: String,
    val message: String,
    val data: String? = null,
    @Serializable(with = InstantSerializer::class)
    val createdAt: Instant
)
