package com.jozze.things.data.remote.dto

import com.jozze.core.common.log
import com.jozze.things.domain.model.Note
import com.jozze.things.domain.model.ThingWrapper
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapter

@JsonClass(generateAdapter = true)
class NoteRequestDto(
    override val name: String,
    override val data: ThingWrapper<Note>
) : ThingDto<Note>()

@JsonClass(generateAdapter = true)
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

//val modules = SerializersModule {
//    polymorphic(ThingDto::class) {
//        subclass(ThingResponseDto::class)
//    }
//}

@OptIn(ExperimentalStdlibApi::class)
fun main() {
/*
    val parser = Json { serializersModule = modules }

//    val noteDto = Json.decodeFromString<NoteResponseDto>(json)
    val noteDto = parser.decodeFromString<ThingResponseDto<Note>>(json)

//    val noteDto = ParseUtil.objectify<ThingResponseDto<Note>>(json)
    val noteJsonString = parser.encodeToString(noteDto)
    log(noteJsonString)
*/

    val moshi = Moshi.Builder().build()
    val noteDto = moshi.adapter<TestModel>().fromJson(json)
    val noteJsonString = moshi.adapter<TestModel>().toJson(noteDto)
    log(noteJsonString)
}