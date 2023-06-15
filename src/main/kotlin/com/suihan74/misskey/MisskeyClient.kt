package com.suihan74.misskey

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.suihan74.misskey.api.account.AccountApi
import com.suihan74.misskey.api.auth.AuthApi
import com.suihan74.misskey.api.miauth.MiAuthApi
import com.suihan74.misskey.api.notes.NotesApi
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

/**
 * Misskeyクライアント
 */
object Misskey {
    private val okHttpClient = OkHttpClient.Builder().build()

    private val json = Json { ignoreUnknownKeys = true }

    // ------ //

    /**
     * miauthを使用したユーザー認証用API
     */
    val miAuth: MiAuthApi = MiAuthApi(retrofitBuilder("https://localhost").build())

    /**
     * 旧来のOAuthを使用したユーザー認証用API
     */
    val auth: AuthApi = AuthApi(retrofitBuilder("https://localhost").build())

    // ------ //

    /**
     * ユーザー認証したクライアントを取得する
     */
    @Suppress("FunctionName")
    fun Client(instance: String, tokenDigest: String) : AuthorizedMisskeyClient {
        val retrofit = retrofitBuilder("https://$instance/").build()
        return AuthorizedMisskeyClient(instance, tokenDigest, retrofit)
    }

    // ------ //

    @OptIn(ExperimentalSerializationApi::class)
    private fun retrofitBuilder(instanceUrl: String) : Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(instanceUrl)
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .client(okHttpClient)
}

/**
 * アカウント連携済みのMisskeyクライアント
 */
class AuthorizedMisskeyClient internal constructor(
    val instance: String,
    tokenDigest: String,
    retrofit: Retrofit
) {
    /**
     * アカウント関連のAPI
     */
    val account: AccountApi = AccountApi(retrofit = retrofit, tokenDigest = tokenDigest)

    /**
     * ノート関連のAPI
     */
    val notes : NotesApi = NotesApi(retrofit = retrofit, tokenDigest = tokenDigest)
}