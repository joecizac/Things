package com.jozze.things.data.repository

import com.jozze.things.common.ApiConstants
import com.jozze.things.data.remote.dto.NoteResponseDto
import com.jozze.things.data.remote.dto.ThingDto
import com.jozze.things.data.remote.dto.ThingResponseDto
import com.jozze.things.domain.model.Thing
import com.jozze.things.domain.repository.ThingsRepository
import io.ktor.client.*
import io.ktor.client.request.*

class ThingsRepositoryImpl(private val httpClient: HttpClient) : ThingsRepository {

    override suspend fun <T : Thing> addThing(thing: ThingDto<T>) {
        httpClient.post<NoteResponseDto> {
            url(ApiConstants.BASE_URL)
            body = thing
        }
    }

    override suspend fun removeThings(id: String) {
        TODO("Not yet implemented")
    }

    override suspend fun <T : Thing> getThing(id: String): ThingResponseDto<T> {
        TODO("Not yet implemented")
    }

    override suspend fun <T : Thing> getThings(vararg ids: String): List<ThingResponseDto<T>> {
        TODO("Not yet implemented")
    }

    override suspend fun <T : Thing> getAllThings(): List<ThingResponseDto<T>> {
        TODO("Not yet implemented")
    }

    override suspend fun <T : Thing> changeThing(thing: ThingDto<T>) {
        TODO("Not yet implemented")
    }

    override suspend fun updateThing(vararg fields: Any) {
        TODO("Not yet implemented")
    }
}