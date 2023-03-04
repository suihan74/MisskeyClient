package com.suihan74.misskey.entity

import com.suihan74.misskey.serializer.InstantISO8601Serializer
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class Page(
    val id: String,

    @Serializable(with = InstantISO8601Serializer::class)
    val createdAt: Instant,

    @Serializable(with = InstantISO8601Serializer::class)
    val updatedAt: Instant,

    val userId: String,

    val user: User,

    val content: Content,

    val variables: List<String>,

    val title: String,

    val name: String,

    val summary: String?,

    val hideTitleWhenPinned: Boolean,

    val alignCenter: Boolean,

    val font: String,

    val script: String,

    val eyeCatchingImageId: String?,

    val eyeCatchingImage: File?,

    val attachedFiles: List<File>,

    val likedCount: Int,

    val isLiked: Boolean
) {
    @Serializable
    data class Content(
        val id: String,

        val `var`: String?,

        val text: String?,

        val type: String, // todo

        val event: String,

        val action: String,

        val content: String?,

        val message: String?,

        val primary: Boolean
    )
}
