package com.jozze.things.domain.model

import com.jozze.things.data.remote.dto.NoteRequestDto

@kotlinx.serialization.Serializable
class Note(
    val title: String,
    val body: String
) : Thing()

@kotlinx.serialization.Serializable
class NoteWrapped(override val kind: Kind, override val thing: Note) : ThingWrapper<Note>()

fun Note.asRequest(): NoteRequestDto {
    val wrappedThing = NoteWrapped(Kind.NOTE, this)
    return NoteRequestDto(title, wrappedThing)
}