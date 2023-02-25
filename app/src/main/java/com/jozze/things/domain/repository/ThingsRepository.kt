package com.jozze.things.domain.repository

import com.jozze.things.data.remote.dto.ThingDto
import com.jozze.things.data.remote.dto.ThingResponseDto
import com.jozze.things.domain.model.Thing

interface ThingsRepository {

    suspend fun <T: Thing> addThing(thing: ThingDto<T>)

    suspend fun removeThings(id: String)

    suspend fun <T: Thing> getThing(id: String): ThingResponseDto<T>

    suspend fun <T: Thing> getThings(vararg ids: String): List<ThingResponseDto<T>>

    suspend fun <T: Thing> getAllThings(): List<ThingResponseDto<T>>

    suspend fun <T: Thing> changeThing(thing: ThingDto<T>)

    suspend fun updateThing(vararg fields: Any)
}