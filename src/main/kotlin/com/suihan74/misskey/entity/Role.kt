package com.suihan74.misskey.entity

import kotlinx.serialization.Serializable

@Serializable
data class Role(
    val id: String,

    val name: String,

    val color: String?,

    val iconUrl: String?,

    val description: String,

    val isModerator: Boolean,

    val isAdministrator: Boolean
)
