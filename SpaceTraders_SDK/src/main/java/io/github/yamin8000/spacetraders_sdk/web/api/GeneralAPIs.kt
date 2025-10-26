package io.github.yamin8000.spacetraders_sdk.web.api

import io.github.yamin8000.spacetraders_sdk.model.status.Status
import io.github.yamin8000.spacetraders_sdk.web.Constants.BASE_API_URL
import io.github.yamin8000.spacetraders_sdk.web.GameClient
import io.ktor.client.call.body

object GeneralAPIs {

    /** Returns the status of the game server. */
    suspend fun GameClient.status(): Status = rawRequest(BASE_API_URL).body()
}