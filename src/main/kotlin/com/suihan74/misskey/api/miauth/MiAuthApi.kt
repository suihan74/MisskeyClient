package com.suihan74.misskey.api.miauth

import retrofit2.Retrofit
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.*

/**
 * インスタント認証API
 */
interface MiAuthApiImpl {
    @POST("https://{host}/api/miauth/gen-token")
    suspend fun generateToken(
        @Path("host") instance: String,
        @Path("body") body: GenerateTokenParams
    ) : TokenResponse

    @POST("https://{host}/api/miauth/{session}/check")
    suspend fun check(
        @Path("host") instance: String,
        @Path("session") sessionId: String
    ) : TokenResponse
}

// ------ //

class MiAuthApi internal constructor(retrofit: Retrofit) {
    private val api = retrofit.create(MiAuthApiImpl::class.java)

    /**
     * miauthを使用して認証するための認証フォームURLを生成する
     *
     */
    suspend fun createMiAuthUrl(
        instance: String,
        name: String,
        description: String? = null,
        iconUrl: String? = null,
        callbackUrl: String? = null,
        permissions: List<String>? = null
    ) : Unit {
        val sessionId = UUID.randomUUID().toString()
        val response = api.generateToken(
            instance = instance,
            body = GenerateTokenParams(
                session = sessionId,
                name = name,
                description = description.orEmpty(),
                iconUrl = iconUrl.orEmpty(),
                permission = permissions.orEmpty()
            )
        )
    }

    suspend fun check(
        miAuthForm: MiAuthForm
    ) : TokenResponse = api.check(instance = miAuthForm.instance, sessionId = miAuthForm.sessionId)
}