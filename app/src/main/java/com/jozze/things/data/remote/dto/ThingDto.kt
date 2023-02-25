package com.jozze.things.data.remote.dto

import com.jozze.things.domain.model.Thing
import com.jozze.things.domain.model.ThingWrapper
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
sealed class ThingDto<T : Thing> {
    abstract val name: String
    abstract val data: ThingWrapper<T>
}

@JsonClass(generateAdapter = true)
sealed class ThingResponseDto<T : Thing> : ThingDto<T>() {
    abstract val id: String
    abstract val createdAt: String
}