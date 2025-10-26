package io.github.yamin8000.spacetraders_sdk.web

import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*

/**
 * Wrapper around [io.ktor.client.HttpClient],
 *
 * This client makes requests prefixed by [baseApiUrl] parameter.
 */
class GameClient(
    private val baseApiUrl: String = Constants.BASE_API_URL,
    private val token: String? = null
) {
    private val _client = HttpClient {
        install(ContentNegotiation) {
            json()
        }
    }

    val client: HttpClient
        get() = _client

    suspend fun get(
        endpoint: String,
        block: HttpRequestBuilder.() -> Unit = { this.method = HttpMethod.Get }
    ) = request(endpoint, block)

    suspend inline fun <reified T> post(
        endpoint: String,
        body: T,
        noinline block: HttpRequestBuilder.() -> Unit = {
            this.method = HttpMethod.Post
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            setBody(body)
        }
    ) = request(endpoint, block)

    suspend fun request(
        endpoint: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ) = _client.request("$baseApiUrl$endpoint", block)

    suspend fun rawRequest(
        url: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ) = _client.request(url, block)

    suspend fun authorizedGet(endpoint: String) = authorizedRequest(endpoint, HttpMethod.Get)

    suspend inline fun <reified T> authorizedPost(
        endpoint: String,
        body: T,
        noinline block: HttpRequestBuilder.() -> Unit = { setBody(body) }
    ) = authorizedRequest(endpoint, HttpMethod.Post, block)

    suspend fun authorizedRequest(
        endpoint: String,
        method: HttpMethod,
        block: HttpRequestBuilder.() -> Unit = {
            this.method = method
            bearerAuth(requireNotNull(token))
        }
    ) = _client.request("$baseApiUrl$endpoint", block)
}