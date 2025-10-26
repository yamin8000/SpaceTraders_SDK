package io.github.yamin8000.spacetraders_sdk

import io.github.yamin8000.spacetraders_sdk.web.api.AgentsAPIs.agents
import io.github.yamin8000.spacetraders_sdk.web.api.AgentsAPIs.findAgent
import io.github.yamin8000.spacetraders_sdk.web.api.AgentsAPIs.myAgent
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class AgentsAPIsTest : MainTest() {

    @Test
    fun myAgent() {
        runBlocking {
            val data = client.myAgent().data
            println(data)
            assertEquals("YS2", data?.symbol)
        }
    }

    @Test
    fun agents() {
        runBlocking {
            val data = client.agents().data
            println(data)
            assertEquals(10, data?.size)
        }
    }

    @Test
    fun findAgent() {
        runBlocking {
            val data = client.findAgent("YS2").data
            println(data)
            assertEquals("YS2", data?.symbol)
        }
    }
}