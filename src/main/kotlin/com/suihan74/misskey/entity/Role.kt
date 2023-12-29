package com.suihan74.misskey.entity

import kotlinx.serialization.Serializable

@Serializable
data class Role(
    val id: String = "",

    val name: String = "",

    val color: String? = null,

    val iconUrl: String? = null,

    val description: String = "",

    val isModerator: Boolean = false,

    val isAdministrator: Boolean = false
)
