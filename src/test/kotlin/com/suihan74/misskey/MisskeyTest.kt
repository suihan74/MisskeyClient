package com.suihan74.misskey

import com.suihan74.misskey.entity.Visibility
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test

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
                    permissions = listOf("write:notes")
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
        }
    }

    @Test
    fun post() {
        runBlocking {
            val client = Misskey.Client(instance = instance, tokenDigest = testTokenDigest)
            val note = client.notes.create(
                text = "テスト投稿",
                visibility = Visibility.Specified
            )
            println(note.text)
        }
    }
}