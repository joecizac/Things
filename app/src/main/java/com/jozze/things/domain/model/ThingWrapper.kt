package com.jozze.things.domain.model

@kotlinx.serialization.Serializable
sealed class ThingWrapper<T: Thing> {
    abstract val kind: Kind
    abstract val thing: T
}

@kotlinx.serialization.Serializable
sealed class Thing

enum class Kind {
    TEXT, NOTE, TODO, REMINDER
}