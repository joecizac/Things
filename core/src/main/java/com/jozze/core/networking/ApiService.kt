package com.jozze.core.networking

import com.jozze.core.common.Constants
import com.jozze.core.common.log
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json

object ApiService {
    fun getClient(): HttpClient {
        return HttpClient(Android) {
            install(HttpTimeout) {
                requestTimeoutMillis = Constants.NETWORK_TIMEOUT_MILLIS
                connectTimeoutMillis = Constants.NETWORK_TIMEOUT_MILLIS
                socketTimeoutMillis = Constants.NETWORK_TIMEOUT_MILLIS
            }

//            install(InternetInterceptor)

            install(DefaultRequest) {
                if (method != HttpMethod.Get)
                    contentType(ContentType.Application.Json)

                accept(ContentType.Application.Json)
            }

//            defaultRequest {
//                if (method != HttpMethod.Get)
//                    contentType(ContentType.Application.Json)
//
//                accept(ContentType.Application.Json)
//            }

//            install(ResponseObserver) {
//                onResponse {
//                    log("${it.status.value}", Constants.TAG_KTOR, com.jozze.core.common.LogLevel.DEBUG)
//                    log("${it.response}", Constants.TAG_KTOR, com.jozze.core.common.LogLevel.DEBUG)
//                }
//            }

            install(JsonFeature) {
                serializer = KotlinxSerializer(json)
            }

            install(Logging) {
//                logger = Logger.SIMPLE
                logger = object : Logger {
                    override fun log(message: String) {
                        log(message, Constants.TAG_KTOR)
                    }
                }
                level = LogLevel.ALL
            }
        }
    }

    private val json = Json {
        /** https://github.com/Kotlin/kotlinx.serialization/blob/master/docs/json.md **/

        ignoreUnknownKeys = true
        isLenient = true
        encodeDefaults = false
        prettyPrint = true
        coerceInputValues = true
        encodeDefaults = true
        allowStructuredMapKeys = true
        classDiscriminator = "#class"
//        serializersModule = serializerModules
    }
}