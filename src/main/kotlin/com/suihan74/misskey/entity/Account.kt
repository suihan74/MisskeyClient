package com.suihan74.misskey.entity

import com.suihan74.misskey.serializer.InstantISO8601Serializer
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class Account(
    val id: String,

    /**
     * 表示名
     */
    val name: String,

    /**
     * ユーザーid
     */
    val username: String,

    /**
     * 自インスタンスの場合null
     */
    val host: String?,

    val avatarUrl: String,

    val avatarBlurhash: String,

    val avatarId: String,

    val bannerUrl: String,

    val bannerBlurhash: String,

    val bannerId: String,

    val isBot: Boolean,

    val isCat: Boolean,

    val emojis: Map<String, String>,

    val onlineStatus: String,

    val badgeRoles: List<User.BadgeRole>,

    val url: String?,

    val uri: String?,

    @Serializable(with = InstantISO8601Serializer::class)
    val createdAt: Instant,

    @Serializable(with = InstantISO8601Serializer::class)
    val updatedAt: Instant,

    @Serializable(with = InstantISO8601Serializer::class)
    val lastFetchedAt: Instant?,

    val isLocked: Boolean,

    val isSilenced: Boolean,

    val isSuspended: Boolean,

    val description: String?,

    val location: String?,

    val birthday: String?,

    val lang: String,

    val fields: List<String>,

    val followersCount: Int,

    val followingCount: Int,

    val notesCount: Int,

    val pinnedNoteIds: List<String>,

    val pinnedNotes: List<Note>,

    val pinnedPageId: String?,

    val pinnedPage: Page?,

    val publicReactions: Boolean,

    val ffVisibility: Visibility,

    val twoFactorEnabled: Boolean,

    val usePasswordLessLogin: Boolean,

    val securityKeys: Boolean,

    val roles: List<Role>,

    val isModerator: Boolean,

    val isAdmin: Boolean,

    val injectFeaturedNote: Boolean,

    val receiveAnnouncementEmail: Boolean,

    val alwaysMarkNsfw: Boolean,

    val autoSensitive: Boolean,

    val carefulBot: Boolean,

    val autoAcceptFollowed: Boolean,

    val noCrawle: Boolean,

    val isExplorable: Boolean,

    val isDeleted: Boolean,

    val hideOnlineStatus: Boolean,

    val hasUnreadSpecifiedNotes: Boolean,

    val hasUnreadMentions: Boolean,

    val hasUnreadMessagingMessage: Boolean? = null,  // removed in v13.9.1

    val hasUnreadAnnouncement: Boolean,

    val hasUnreadAntenna: Boolean,

    val hasUnreadChannel: Boolean,

    val hasUnreadNotification: Boolean,

    val hasPendingReceivedFollowRequest: Boolean,

    val mutedWords: List<String>,

    val mutedInstances: List<String>,

    val mutingNotificationTypes: List<String>,

    val emailNotificationTypes: List<String>, // todo

    val achievements: List<Achievement>,

    val loggedInDays: Int,

    val email: String? = null,

    val emailVerified: Boolean = false,

    val policies: Policies,

    val securityKeysList: List<String> = emptyList()
)
