package com.suihan74.misskey.api.notes

import com.suihan74.misskey.entity.Note
import kotlinx.serialization.Serializable

@Serializable
data class CreateNoteResponse(
    val createdNote: Note
)