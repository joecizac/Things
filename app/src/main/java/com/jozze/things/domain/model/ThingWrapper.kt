package com.jozze.things.domain.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
sealed class ThingWrapper<T: Thing> {
    abstract val kind: Kind
    abstract val thing: T
}

@JsonClass(generateAdapter = true)
sealed class Thing

@JsonClass(generateAdapter = false)
enum class Kind {
    TEXT, NOTE, TODO, REMINDER
}