package io.github.yamin8000.spacetraders_sdk.model.account

import io.github.yamin8000.spacetraders_sdk.model.utils.InstantSerializer
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class Account(
    val id: String,
    val email: String,
    val token: String,
    @Serializable(with = InstantSerializer::class)
    val createdAt: Instant
)
