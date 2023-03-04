package com.suihan74.misskey.entity

import kotlinx.serialization.Serializable

@Serializable
data class Policies(
    val gtlAvailable: Boolean,

    val ltlAvailable: Boolean,

    val canPublicNote: Boolean,

    val canInvite: Boolean,

    val canManageCustomEmojis: Boolean,

    val canHideAds: Boolean,

    val driveCapacityMb: Int,

    val pinLimit: Int,

    val antennaLimit: Int,

    val wordMuteLimit: Int,

    val webhookLimit: Int,

    val clipLimit: Int,

    val noteEachClipsLimit: Int,

    val userListLimit: Int,

    val userEachUserListsLimit: Int,

    val rateLimitFactor: Float
)
