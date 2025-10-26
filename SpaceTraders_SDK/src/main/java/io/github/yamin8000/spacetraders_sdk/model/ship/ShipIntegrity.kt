package io.github.yamin8000.spacetraders_sdk.model.ship

import kotlinx.serialization.Serializable

/**
 * The overall integrity of the component, which determines the performance
 * of the component. A value of 0 indicates that the component is almost
 * completely degraded, while a value of 1 indicates that the component
 * is in near perfect condition. The integrity of the component is
 * non-repairable, and represents permanent wear over time.
 */
@Serializable
@JvmInline
value class ShipIntegrity(val value: Double)