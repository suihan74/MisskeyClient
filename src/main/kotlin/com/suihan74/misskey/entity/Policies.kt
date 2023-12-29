package com.suihan74.misskey.entity

import kotlinx.serialization.Serializable

@Serializable
data class Policies(
    val gtlAvailable: Boolean = false,

    val ltlAvailable: Boolean = false,

    val canPublicNote: Boolean = false,

    val canInvite: Boolean = false,

    val canManageCustomEmojis: Boolean = false,

    val canHideAds: Boolean = false,

    val driveCapacityMb: Int = 0,

    val pinLimit: Int = 0,

    val antennaLimit: Int = 0,

    val wordMuteLimit: Int = 0,

    val webhookLimit: Int = 0,

    val clipLimit: Int = 0,

    val noteEachClipsLimit: Int = 0,

    val userListLimit: Int = 0,

    val userEachUserListsLimit: Int = 0,

    val rateLimitFactor: Float = 0f
)
