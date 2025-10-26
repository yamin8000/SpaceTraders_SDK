package io.github.yamin8000.spacetraders_sdk

import io.github.yamin8000.spacetraders_sdk.web.api.GeneralAPIs.status
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class StatusAPITest : MainTest() {

    @Test
    fun status() {
        runBlocking {
            val status = client.status()
            println(status)
            assertEquals(
                "SpaceTraders is currently online and available to play",
                status.status
            )
        }
    }
}