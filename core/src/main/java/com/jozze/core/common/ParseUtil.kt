package com.jozze.core.common

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object ParseUtil {

    inline fun <reified T> stringify(obj: T) = Json.encodeToString(obj)

    inline fun <reified T : Any> objectify(jsonString: String): T {
        return Json.decodeFromString(jsonString)
    }
}