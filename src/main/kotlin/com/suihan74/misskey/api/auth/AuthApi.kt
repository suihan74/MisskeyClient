package com.suihan74.misskey.api.auth

import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path
import java.security.MessageDigest

/**
 * アプリケーション登録API
 */
interface AuthApiImpl {
    @POST("https://{host}/api/app/create")
    suspend fun createApp(
        @Path("host") instance: String,
        @Body body: CreateParams
    ) : App

    @POST("https://{host}/api/auth/session/generate")
    suspend fun generateSession(
        @Path("host") instance: String,
        @Body body: GenerateSessionParams
    ) : GenerateSessionResponse

    @POST("https://{host}/api/auth/session/userkey")
    suspend fun getAccessToken(
        @Path("host") instance: String,
        @Body body: AccessTokenParams
    ) : AccessTokenResponse
}

// ------ //

class AuthApi internal constructor(retrofit: Retrofit) {
    private val api = retrofit.create(AuthApiImpl::class.java)

    /**
     * アプリを登録しシークレットキーを取得する
     */
    suspend fun createApp(
        instance: String,
        name: String,
        description: String,
        permissions: List<String> = emptyList(),
        callbackUrl: String? = null
    ) : AppCredential {
        val app = api.createApp(
            instance = instance,
            body = CreateParams(
                name = name,
                description = description,
                permission = permissions,
                callbackUrl = callbackUrl
            )
        )
        return AppCredential(
            instance = instance,
            app = app
        )
    }

    /**
     * 認証用URLとトークンを取得する
     */
    suspend fun generateSession(appCredential: AppCredential) : GenerateSessionResponse =
        api.generateSession(
            instance = appCredential.instance,
            body = GenerateSessionParams(appSecret = appCredential.app.secret)
        )

    /**
     * アプリのシークレットキーと、ブラウザなどで認証したトークンからAPIのアクセストークンを取得する
     */
    suspend fun getAccessToken(
        appCredential: AppCredential,
        session: GenerateSessionResponse
    ) : String {
        val response = api.getAccessToken(
            instance = appCredential.instance,
            body = AccessTokenParams(
                appSecret = appCredential.app.secret,
                token = session.token
            )
        )
        return MessageDigest.getInstance("SHA-256")
            .digest((response.accessToken + appCredential.app.secret).toByteArray())
            .joinToString(separator = "") { "%02x".format(it) }
    }
}