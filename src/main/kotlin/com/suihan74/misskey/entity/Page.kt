package com.suihan74.misskey.entity

import com.suihan74.misskey.serializer.InstantISO8601Serializer
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class Page(
    val id: String = "",

    @Serializable(with = InstantISO8601Serializer::class)
    val createdAt: Instant = Instant.MIN,

    @Serializable(with = InstantISO8601Serializer::class)
    val updatedAt: Instant = Instant.MIN,

    val userId: String = "",

    val user: User = User(),

    val content: Content = Content(),

    val variables: List<String> = emptyList(),

    val title: String = "",

    val name: String = "",

    val summary: String? = null,

    val hideTitleWhenPinned: Boolean = false,

    val alignCenter: Boolean = false,

    val font: String = "",

    val script: String = "",

    val eyeCatchingImageId: String? = null,

    val eyeCatchingImage: File? = null,

    val attachedFiles: List<File> = emptyList(),

    val likedCount: Int = 0,

    val isLiked: Boolean = false
) {
    @Serializable
    data class Content(
        val id: String = "",

        val `var`: String? = null,

        val text: String? = null,

        val type: String = "", // todo

        val event: String = "",

        val action: String = "",

        val content: String? = null,

        val message: String? = null,

        val primary: Boolean = false
    )
}
