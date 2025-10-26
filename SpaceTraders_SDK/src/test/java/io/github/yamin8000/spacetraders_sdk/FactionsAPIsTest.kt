package io.github.yamin8000.spacetraders_sdk

import io.github.yamin8000.spacetraders_sdk.web.api.FactionsAPIs.factions
import io.github.yamin8000.spacetraders_sdk.web.api.FactionsAPIs.getFaction
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class FactionsAPIsTest : MainTest() {

    @Test
    fun factions() {
        runBlocking {
            assertEquals(1, client.factions(limit = 1).data?.size)
        }
    }

    @Test
    fun getFaction() {
        runBlocking {
            assertEquals("COSMIC", client.getFaction("COSMIC").data?.symbol?.name)
        }
    }
}