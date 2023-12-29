package com.suihan74.misskey.entity

import com.suihan74.misskey.serializer.InstantISO8601Serializer
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class File(
    val id: String = "",

    @Serializable(with = InstantISO8601Serializer::class)
    val createdAt: Instant = Instant.MIN,

    val name: String = "",

    val type: String = "",

    val md5: String = "",

    val size: Int = 0,

    val isSensitive: Boolean = false,

    val blurhash: String = "",

    val properties: Properties = Properties(),

    val url: String = "",

    val thumbnailUrl: String? = null,

    val comment: String? = null,

    val folderId: String? = null,

    val folder: String? = null, // todo

    val userId: String? = null,

    val user: User? = null
) {
    @Serializable
    data class Properties(
        val width: Int = 0,
        val height: Int = 0
    )
}
