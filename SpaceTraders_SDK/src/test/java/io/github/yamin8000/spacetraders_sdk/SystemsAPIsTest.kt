package io.github.yamin8000.spacetraders_sdk

import io.github.yamin8000.spacetraders_sdk.web.api.SystemsAPIs.getSystem
import io.github.yamin8000.spacetraders_sdk.web.api.SystemsAPIs.getWaypoint
import io.github.yamin8000.spacetraders_sdk.web.api.SystemsAPIs.systems
import io.github.yamin8000.spacetraders_sdk.web.api.SystemsAPIs.waypoints
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

private const val TEST_SYSTEM = "X1-ZA40"

private const val TEST_WAYPOINT = "X1-ZA40-15970B"

class SystemsAPIsTest : MainTest() {

    @Test
    fun systems() {
        runBlocking {
            assertEquals(
                TEST_SYSTEM,
                client.systems().data?.map { it.symbol }?.find { it == TEST_SYSTEM }
            )
        }
    }

    @Test
    fun getSystem() {
        runBlocking {
            assertEquals(TEST_SYSTEM, client.getSystem(TEST_SYSTEM).data?.symbol)
        }
    }

    @Test
    fun waypointsWithSystemSymbol() {
        runBlocking {
            assertEquals(
                TEST_SYSTEM,
                client.waypoints(TEST_SYSTEM).data?.map { it.systemSymbol }
                    ?.find { it == TEST_SYSTEM }
            )
        }
    }

    @Test
    fun waypointsWithSystem() {
        runBlocking {
            val system = client.getSystem(TEST_SYSTEM).data
            assertEquals(
                TEST_SYSTEM,
                client.waypoints(system!!).data?.map { it.systemSymbol }?.find { it == TEST_SYSTEM }
            )
        }
    }

    @Test
    fun getWaypoint() {
        runBlocking {
            assertEquals(
                TEST_SYSTEM,
                client.getWaypoint(TEST_SYSTEM, TEST_WAYPOINT).data?.systemSymbol
            )
        }
    }

    @Test
    fun getWaypointWithSystem() {
        runBlocking {
            val system = client.getSystem(TEST_SYSTEM).data
            assertEquals(
                TEST_SYSTEM,
                client.getWaypoint(system!!, TEST_WAYPOINT).data?.systemSymbol
            )
        }
    }
}