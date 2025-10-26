package io.github.yamin8000.spacetraders_sdk.model.api

import kotlinx.serialization.Serializable

@Serializable
data class ApiError(
    val message: String,
    val code: Int,
    val data: Map<String, String>? = null,
    val requestId: String? = null
)
