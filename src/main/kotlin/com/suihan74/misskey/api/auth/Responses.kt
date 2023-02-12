package com.suihan74.misskey.api.auth

import kotlinx.serialization.Serializable

/**
 * アプリのシークレットキー
 */
@Serializable
data class App(
    val id: String,
    val name: String,
    val callbackUrl: String?,
    val permission: List<String>,
    val secret: String
)

data class AppCredential(
    val instance: String,
    val app: App
)

// ------ //

@Serializable
data class GenerateSessionResponse(
    val token: String,

    val url: String
)

@Serializable
data class AccessTokenResponse(
    val accessToken: String
)