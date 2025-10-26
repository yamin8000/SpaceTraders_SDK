package io.github.yamin8000.spacetraders_sdk

import io.github.yamin8000.spacetraders_sdk.web.api.ShipAPIs.ships
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ShipsAPIsTest : MainTest() {

    @Test
    fun ships() {
        runBlocking {
            val data = client.ships().data
            println(data)
        }
    }
}