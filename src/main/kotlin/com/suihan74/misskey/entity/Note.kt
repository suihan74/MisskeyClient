package com.suihan74.misskey.entity

import com.suihan74.misskey.serializer.InstantISO8601Serializer
import kotlinx.serialization.Serializable
import java.time.Instant

/**
 * ノート
 */
@Serializable
data class Note(
    val id: String,

    @Serializable(with = InstantISO8601Serializer::class)
    val createdAt: Instant,

    val text: String?,

    val cw: String?,

    val user: User,

    val userId: String,

    val visibility: Visibility
)
