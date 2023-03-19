package com.suihan74.misskey.api.notes

import com.suihan74.misskey.entity.Visibility
import com.suihan74.misskey.serializer.InstantEpochSecondSerializer
import kotlinx.serialization.Serializable
import java.time.Instant

/**
 * 投票パラメータ
 */
@Serializable
data class Poll(
    /**
     * 選択肢。
     */
    val choices: List<String>,
    /**
     * trueにすると、複数選択を許容します。
     */
    val multiple: Boolean,
    /**
     * 投票の締め切り。エポック秒で指定します
     */
    @Serializable(with = InstantEpochSecondSerializer::class)
    val expiresAt: Instant?,
    /**
     * 指定すると、ノート作成から[expiredAfter]秒後に投票を締め切ります。[expiresAt]と併せて指定した場合、[expiresAt]が優先されます。
     */
    val expiredAfter: Long?
)

/**
 * 投稿パラメータ
 */
@Serializable
data class CreateParamsWithFileIds(
    val i: String,
    val visibility: Visibility,
    val visibleUserIds: List<String>,
    val text: String?,
    val cw: String?,
    val localOnly: Boolean,
    val noExtractMentions: Boolean,
    val noExtractHashtags: Boolean,
    val noExtractEmojis: Boolean,
    val fileIds: List<String>,
    val replyId: String?,
    val renoteId: String?,
    val channelId: String?,
    val poll: Poll?
)

/**
 * 投稿パラメータ
 */
@Serializable
data class CreateParams(
    val i: String,
    val visibility: Visibility,
    val visibleUserIds: List<String>,
    val text: String?,
    val cw: String?,
    val localOnly: Boolean,
    val noExtractMentions: Boolean,
    val noExtractHashtags: Boolean,
    val noExtractEmojis: Boolean,
    val replyId: String?,
    val renoteId: String?,
    val channelId: String?,
    val poll: Poll?
)