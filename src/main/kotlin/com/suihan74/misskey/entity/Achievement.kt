package com.suihan74.misskey.entity

import com.suihan74.misskey.serializer.InstantEpochSecondSerializer
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class Achievement(
    val name: String = "",

    @Serializable(with = InstantEpochSecondSerializer::class)
    val unlockedAt: Instant = Instant.MIN
)
