package com.jozze.things.domain.model

import com.jozze.things.data.remote.dto.NoteRequestDto
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Note(
    val title: String,
    val body: String
) : Thing()

@JsonClass(generateAdapter = true)
class NoteWrapped(override val kind: Kind, override val thing: Note) : ThingWrapper<Note>()

fun Note.asRequest(): NoteRequestDto {
    val wrappedThing = NoteWrapped(Kind.NOTE, this)
    return NoteRequestDto(title, wrappedThing)
}