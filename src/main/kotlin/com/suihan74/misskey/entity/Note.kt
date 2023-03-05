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

    val userId: String,

    val user: User,

    val text: String?,

    val cw: String?,

    val visibility: Visibility,

    val localOnly: Boolean,

    val renoteCount: Int,

    val repliesCount: Int,

    val reactions: Map<String, Int>,

    val reactionEmojis: Map<String, String>,

    val fileIds: List<String>,

    val files: List<File>,

    val replyId: String?,

    val renoteId: String?,

    val mentions: List<String> = emptyList()
)
