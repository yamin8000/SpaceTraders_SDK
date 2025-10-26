package io.github.yamin8000.spacetraders_sdk

import io.github.yamin8000.spacetraders_sdk.model.account.RegisterRequest
import io.github.yamin8000.spacetraders_sdk.model.faction.FactionSymbol
import io.github.yamin8000.spacetraders_sdk.web.api.AccountAPIs.register
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class AccountAPIsTest : MainTest() {

    @Test
    fun register() {
        runBlocking {
            val faction = FactionSymbol.entries.random()
            val request = RegisterRequest(
                faction = faction,
                symbol = System.getenv("AGENT_SYMBOL"),
            )
            val response = client.register(request)
            println(response)
            assertEquals(faction, response.data?.faction?.symbol)
        }
    }
}