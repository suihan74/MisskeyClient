package com.suihan74.misskey.api.notes

import com.suihan74.misskey.entity.Note
import com.suihan74.misskey.entity.Visibility
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * 投稿API
 */
interface NotesApiImpl {
    @POST("api/notes/create")
    suspend fun create(@Body body: CreateParams) : CreateNoteResponse

    @POST("api/notes/create")
    suspend fun create(@Body body: CreateParamsWithFileIds) : CreateNoteResponse

}

// ------ //

class NotesApi internal constructor(
    retrofit: Retrofit,
    private val tokenDigest: String
) {
    private val api = retrofit.create(NotesApiImpl::class.java)

    /**
     * ノートを投稿する
     *
     * @param visibility ノートの公開範囲。
     * @param visibleUserIds ノートを閲覧可能なユーザーのidのリスト。[visibility]が[Visibility.Specified]の場合のみ適用されます。
     * @param text ノートの本文。
     * @param localOnly trueにすると、ローカルのみに投稿されます。
     * @param noExtractMentions trueにすると、本文からメンションを展開しません。
     * @param noExtractHashtags trueにすると、本文からハッシュタグを展開しません。
     * @param noExtractEmojis trueにすると、本文から絵文字を展開しません。
     * @param fileIds 添付するファイルのid。
     * @param replyId 返信先のノートのid。
     * @param renoteId Renote対象のノートのid。
     * @param channelId 投稿先のチャンネルのid。
     * @param poll 投票に関するパラメータ。
     */
    suspend fun create(
        visibility: Visibility = Visibility.Public,
        visibleUserIds: List<String> = emptyList(),
        text: String? = null,
        cw: String? = null,
        localOnly: Boolean = false,
        noExtractMentions: Boolean = false,
        noExtractHashtags: Boolean = false,
        noExtractEmojis: Boolean = false,
        fileIds: List<String>? = null,
        replyId: String? = null,
        renoteId: String? = null,
        channelId: String? = null,
        poll: Poll? = null
    ) : Note {
        return fileIds?.let {
            createWithFileIds(
                visibility = visibility,
                visibleUserIds = visibleUserIds,
                text = text,
                cw = cw,
                localOnly = localOnly,
                noExtractMentions = noExtractMentions,
                noExtractHashtags = noExtractHashtags,
                noExtractEmojis = noExtractEmojis,
                fileIds = fileIds,
                replyId = replyId,
                renoteId = renoteId,
                channelId = channelId,
                poll = poll
            )
        } ?: createWithoutFileIds(
            visibility = visibility,
            visibleUserIds = visibleUserIds,
            text = text,
            cw = cw,
            localOnly = localOnly,
            noExtractMentions = noExtractMentions,
            noExtractHashtags = noExtractHashtags,
            noExtractEmojis = noExtractEmojis,
            replyId = replyId,
            renoteId = renoteId,
            channelId = channelId,
            poll = poll
        )
    }

    private suspend fun createWithFileIds(
        visibility: Visibility,
        visibleUserIds: List<String>,
        text: String?,
        cw: String?,
        localOnly: Boolean,
        noExtractMentions: Boolean,
        noExtractHashtags: Boolean,
        noExtractEmojis: Boolean,
        fileIds: List<String>,
        replyId: String?,
        renoteId: String?,
        channelId: String?,
        poll: Poll?
    ) : Note {
        val response = api.create(
            body = CreateParamsWithFileIds(
                i = tokenDigest,
                visibility = visibility,
                visibleUserIds = visibleUserIds,
                text = text,
                cw = cw,
                localOnly = localOnly,
                noExtractMentions = noExtractMentions,
                noExtractHashtags = noExtractHashtags,
                noExtractEmojis = noExtractEmojis,
                fileIds = fileIds,
                replyId = replyId,
                renoteId = renoteId,
                channelId = channelId,
                poll = poll
            )
        )
        return response.createdNote
    }

    private suspend fun createWithoutFileIds(
        visibility: Visibility,
        visibleUserIds: List<String>,
        text: String?,
        cw: String?,
        localOnly: Boolean,
        noExtractMentions: Boolean,
        noExtractHashtags: Boolean,
        noExtractEmojis: Boolean,
        replyId: String?,
        renoteId: String?,
        channelId: String?,
        poll: Poll?
    ) : Note {
        val response = api.create(
            body = CreateParams(
                i = tokenDigest,
                visibility = visibility,
                visibleUserIds = visibleUserIds,
                text = text,
                cw = cw,
                localOnly = localOnly,
                noExtractMentions = noExtractMentions,
                noExtractHashtags = noExtractHashtags,
                noExtractEmojis = noExtractEmojis,
                replyId = replyId,
                renoteId = renoteId,
                channelId = channelId,
                poll = poll
            )
        )
        return response.createdNote
    }
}