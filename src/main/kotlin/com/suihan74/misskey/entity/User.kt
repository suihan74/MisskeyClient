package com.suihan74.misskey.entity

import com.suihan74.misskey.serializer.InstantISO8601Serializer
import kotlinx.serialization.Serializable
import java.time.Instant

/**
 * ユーザー情報
 */
@Serializable
data class User(
    val id: String,

//    @Serializable(with = InstantISO8601Serializer::class)
//    val createdAt: Instant,

    val username: String,

    val host: String?,

    val name: String,

    val onlineStatus: String,

    val avatarUrl: String,

    val avatarBlurhash: String
)
