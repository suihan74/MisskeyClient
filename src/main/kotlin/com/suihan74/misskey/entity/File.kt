package com.suihan74.misskey.entity

import com.suihan74.misskey.serializer.InstantISO8601Serializer
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class File(
    val id: String,

    @Serializable(with = InstantISO8601Serializer::class)
    val createdAt: Instant,

    val name: String,

    val type: String,

    val md5: String,

    val size: Int,

    val isSensitive: Boolean,

    val blurhash: String,

    val properties: Properties,

    val url: String,

    val thumbnailUrl: String?,

    val comment: String?,

    val folderId: String?,

    val folder: String?, // todo

    val userId: String?,

    val user: User?
) {
    @Serializable
    data class Properties(
        val width: Int,
        val height: Int
    )
}
