package com.suihan74.misskey.api.auth

import kotlinx.serialization.Serializable

@Serializable
data class CreateParams(
    val name: String,

    val description: String,

    val callbackUrl: String?,

    // todo: 使用できるパーミッション一覧が不明
    val permission: List<String>
)

// ------- //

@Serializable
data class GenerateSessionParams(
    val appSecret: String
)

// ------ //

@Serializable
data class AccessTokenParams(
    val appSecret: String,

    val token: String
)