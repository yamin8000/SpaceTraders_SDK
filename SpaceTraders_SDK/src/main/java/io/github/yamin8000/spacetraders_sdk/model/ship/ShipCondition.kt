package io.github.yamin8000.spacetraders_sdk.model.ship

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmInline

/**
 * The repairable condition of a component. A value of 0 indicates the
 * component needs significant repairs, while a value of 1 indicates
 * the component is in near perfect condition. As the condition of a
 * component is repaired, the overall integrity of the component decreases.
 */
@Serializable
@JvmInline
value class ShipCondition(val value: Double)