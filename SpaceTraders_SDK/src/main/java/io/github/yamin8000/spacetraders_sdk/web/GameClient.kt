package io.github.yamin8000.spacetraders_sdk.web

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.header
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.serialization.kotlinx.json.json

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
        block: HttpRequestBuilder.() -> Unit = {}
    ) = request(
        endpoint = endpoint,
        block = {
            this.method = HttpMethod.Get
            block()
        }
    )

    suspend inline fun <reified T> post(
        endpoint: String,
        body: T,
        noinline block: HttpRequestBuilder.() -> Unit = {}
    ) = request(
        endpoint = endpoint,
        block = {
            this.method = HttpMethod.Post
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            setBody(body)
            block()
        }
    )

    suspend fun authorizedGet(endpoint: String) = authorizedRequest(endpoint, HttpMethod.Get)

    suspend inline fun <reified T> authorizedPost(
        endpoint: String,
        body: T,
        noinline block: HttpRequestBuilder.() -> Unit = {}
    ) = authorizedRequest(
        endpoint = endpoint,
        method = HttpMethod.Post,
        block = {
            setBody(body)
            header(HttpHeaders.ContentType, ContentType.Application.Json)
            block()
        }
    )

    suspend fun authorizedRequest(
        endpoint: String,
        method: HttpMethod,
        block: HttpRequestBuilder.() -> Unit = {}
    ) = _client.request(
        urlString = "$baseApiUrl$endpoint",
        block = {
            this.method = method
            bearerAuth(requireNotNull(token))
            block()
        }
    )

    suspend fun request(
        endpoint: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ) = _client.request("$baseApiUrl$endpoint", block)

    suspend fun rawRequest(
        url: String,
        block: HttpRequestBuilder.() -> Unit = {}
    ) = _client.request(url, block)
}