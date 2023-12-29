package com.suihan74.misskey

import com.suihan74.misskey.entity.Visibility
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import retrofit2.HttpException
import kotlin.test.assertEquals

internal class MisskeyTest : TestCredential() {
    private val instance = "misskey.io"

    @Test
    fun miauth() {
        /*
        runBlocking {
            val form = Misskey.miAuth.createMiAuthUrl(
                instance = instance,
                name = "すいはんのーと",
                permissions = listOf("write:notes")
            )
            println("url: ${form.url}")
            println("session: ${form.sessionId}")

            val credential = Misskey.miAuth.check(form)
            println("token: ${credential.token}")

            val client = Misskey.Client(instance = instance, token = credential.token)
            client.notes.create(text = "APIぶったたいてみた")
        }
        */
    }

    @Test
    fun auth() {
        runBlocking {
            runCatching {
                val appCredential = Misskey.auth.createApp(
                    instance = instance,
                    name = "すいはんのーと",
                    description = "@suihan74",
                    permissions = listOf("write:notes", "read:account"),
                    callbackUrl = "https://localhost/"
                )
                println("appSecret: ${appCredential.app.secret}")

                val session = Misskey.auth.generateSession(appCredential)
                println("token: ${session.token}")
                println("url: ${session.url}")

                val accessToken = Misskey.auth.getAccessToken(appCredential, session)
                println("accessToken: $accessToken")
            }
        }.onFailure {
            it.printStackTrace()
            throw it
        }
    }

    @Test
    fun post() {
        runBlocking {
            runCatching {
                val client = Misskey.Client(instance = instance, tokenDigest = testTokenDigest)
                client.notes.create(
                    text = "APIテスト投稿",
                    visibility = Visibility.Specified
                )
            }.onFailure {
                it as HttpException
                val error = it.response()?.errorBody()?.string()
                println(error)
                throw it
            }.onSuccess { note ->
                println(note.text)
            }
        }
    }

    @Test
    fun i() {
        runBlocking {
            val client = Misskey.Client(instance = instance, tokenDigest = testTokenDigest)
            val account = client.account.i()
            assertEquals("suihan74", account.username)
        }
    }
}