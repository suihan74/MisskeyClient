package com.suihan74.misskey.entity

import com.suihan74.misskey.serializer.InstantISO8601Serializer
import kotlinx.serialization.Serializable
import java.time.Instant

/**
 * ノート
 */
@Serializable
data class Note(
    val id: String = "",

    @Serializable(with = InstantISO8601Serializer::class)
    val createdAt: Instant = Instant.MIN,

    val userId: String = "",

    val user: User = User(),

    val text: String? = null,

    val cw: String? = null,

    val visibility: Visibility = Visibility.Public,

    val localOnly: Boolean = false,

    val renoteCount: Int = 0,

    val repliesCount: Int = 0,

    val reactions: Map<String, Int> = emptyMap(),

    val reactionEmojis: Map<String, String> = emptyMap(),

    val fileIds: List<String> = emptyList(),

    val files: List<File> = emptyList(),

    val replyId: String? = null,

    val renoteId: String? = null,

    val mentions: List<String> = emptyList()
)
