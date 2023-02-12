package com.suihan74.misskey.api.miauth

import kotlinx.serialization.Serializable

@Serializable
data class GenerateTokenParams(
    val session: String,

    val name: String,

    val description: String,

    val iconUrl: String,

    val permission: List<String>
)