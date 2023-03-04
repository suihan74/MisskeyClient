package com.suihan74.misskey.api.account

import com.suihan74.misskey.api.NoParams
import com.suihan74.misskey.entity.Account
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * 投稿API
 */
interface AccountApiImpl {
    @POST("api/i")
    suspend fun i(@Body body: NoParams) : Account
}

// ------ //

class AccountApi internal constructor(
    retrofit: Retrofit,
    private val tokenDigest: String
) {
    private val api = retrofit.create(AccountApiImpl::class.java)

    /**
     * 自分のユーザー情報を取得する
     */
    suspend fun i() : Account = api.i(NoParams(i = tokenDigest))
}
