package com.jozze.things.data.remote.dto

import com.jozze.core.common.log
import com.jozze.things.domain.model.Note
import com.jozze.things.domain.model.ThingWrapper
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

@kotlinx.serialization.Serializable
class NoteRequestDto(
    override val name: String,
    override val data: ThingWrapper<Note>
) : ThingDto<Note>()

@kotlinx.serialization.Serializable
class NoteResponseDto(
    override val id: String,
    override val createdAt: String,
    override val name: String,
    override val data: ThingWrapper<Note>,
) : ThingResponseDto<Note>()

val json = """
    {
      "id": "ff808181865cf67e018664fd970a0224",
      "createdAt": "2023-02-18T14:46:26.315+00:00",
      "name": "some title",
      "data": {
        "type": "com.jozze.things.domain.model.NoteWrapped",
        "kind": "NOTE",
        "thing": {
          "title": "some title",
          "body": "some text message"
        }
      }
    }
""".trimIndent()

val modules = SerializersModule {
    polymorphic(ThingDto::class) {
        subclass(ThingResponseDto::class)
    }
}

fun main() {
    val parser = Json { modules = modules }
//    val noteDto = Json.decodeFromString<NoteResponseDto>(json)
    val noteDto = Json.decodeFromString<ThingResponseDto<Note>>(json)
    Note.serializer()
//    val noteDto = ParseUtil.objectify<ThingResponseDto<Note>>(json)
    val noteJsonString = Json.encodeToString(noteDto)
    log(noteJsonString)
}