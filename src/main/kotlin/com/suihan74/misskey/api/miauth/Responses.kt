package com.suihan74.misskey.api.miauth

import com.suihan74.misskey.entity.User
import kotlinx.serialization.Serializable

/**
 * 認証フォームのURLと使用するセッションID
 */
@Serializable
data class MiAuthForm(
    /**
     * インスタンス
     */
    val instance: String,

    /**
     * 認証フォームURL
     */
    val url: String,

    /**
     * セッションID
     */
    val sessionId: String
)

// ------ //

@Serializable
data class TokenResponse(
    /**
     * ユーザーのアクセストークン
     */
    val token: String,

    /**
     * ユーザーの情報
     */
    val user: User
)