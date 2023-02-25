package com.jozze.things.data.remote.dto


import androidx.annotation.Keep
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class TestModel(
    val id: String,
    val createdAt: String,
    val name: String
)