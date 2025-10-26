package io.github.yamin8000.spacetraders_sdk

import io.github.yamin8000.spacetraders_sdk.model.RegisterRequest
import io.github.yamin8000.spacetraders_sdk.model.faction.FactionSymbol
import io.github.yamin8000.spacetraders_sdk.web.api.GeneralAPIs.register
import io.github.yamin8000.spacetraders_sdk.web.api.GeneralAPIs.status
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class GeneralAPIsTest : MainTest() {

    @Test
    fun register() {
        runBlocking {
            val request = RegisterRequest(
                faction = FactionSymbol.COSMIC,
                symbol = System.getenv("AGENT_SYMBOL"),
                email = System.getenv("AGENT_EMAIL")
            )
            val response = client.register(request)
            println(response.data)
            assertEquals(FactionSymbol.COSMIC, response.data?.faction?.symbol)
        }
    }
}