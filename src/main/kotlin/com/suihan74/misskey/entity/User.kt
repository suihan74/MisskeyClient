package com.suihan74.misskey.entity

import kotlinx.serialization.Serializable

/**
 * ユーザー情報
 */
@Serializable
data class User(
    val id: String,

    val username: String,

    val host: String?,

    val name: String,

    val onlineStatus: String,

    val avatarUrl: String,

    val avatarBlurhash: String,

    val isBot: Boolean,

    val isCat: Boolean,

    val instance: Instance? = null,

    val emojis: Map<String, String>,

    val badgeRoles: List<BadgeRole>? = null
) {
    @Serializable
    data class Instance(
        val name: String,

        val softwareName: String,

        val softwareVersion: String,

        val iconUrl: String,

        val faviconUrl: String,

        val themeColor: String?
    )

    @Serializable
    data class BadgeRole(
        val name: String,

        val iconUrl: String
    )
}
