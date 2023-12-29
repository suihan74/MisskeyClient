package com.suihan74.misskey.entity

import com.suihan74.misskey.serializer.InstantISO8601Serializer
import kotlinx.serialization.Serializable
import java.time.Instant

@Serializable
data class Account(
    val id: String = "",

    /**
     * 表示名
     */
    val name: String = "",

    /**
     * ユーザーid
     */
    val username: String = "",

    /**
     * 自インスタンスの場合null
     */
    val host: String? = null,

    val avatarUrl: String = "",

    val avatarBlurhash: String = "",

    val avatarId: String = "",

    val bannerUrl: String = "",

    val bannerBlurhash: String = "",

    val bannerId: String = "",

    val isBot: Boolean = false,

    val isCat: Boolean = false,

    val emojis: Map<String, String> = emptyMap(),

    val onlineStatus: String = "",

    val badgeRoles: List<User.BadgeRole> = emptyList(),

    val url: String? = null,

    val uri: String? = null,

    @Serializable(with = InstantISO8601Serializer::class)
    val createdAt: Instant = Instant.MIN,

    @Serializable(with = InstantISO8601Serializer::class)
    val updatedAt: Instant = Instant.MIN,

    @Serializable(with = InstantISO8601Serializer::class)
    val lastFetchedAt: Instant? = null,

    val isLocked: Boolean = false,

    val isSilenced: Boolean = false,

    val isSuspended: Boolean = false,

    val description: String? = null,

    val location: String? = null,

    val birthday: String? = null,

    val lang: String = "",

    val fields: List<String> = emptyList(),

    val followersCount: Int = 0,

    val followingCount: Int = 0,

    val notesCount: Int = 0,

    val pinnedNoteIds: List<String> = emptyList(),

    val pinnedNotes: List<Note> = emptyList(),

    val pinnedPageId: String? = null,

    val pinnedPage: Page? = null,

    val publicReactions: Boolean = false,

    val ffVisibility: Visibility = Visibility.Public,  // removed in 2023.12.x

    val followingVisibility: Visibility = Visibility.Public,

    val followersVisibility: Visibility = Visibility.Public,

    val twoFactorEnabled: Boolean = false,

    val usePasswordLessLogin: Boolean = false,

    val securityKeys: Boolean = false,

    val roles: List<Role> = emptyList(),

    val isModerator: Boolean = false,

    val isAdmin: Boolean = false,

    val injectFeaturedNote: Boolean = false,

    val receiveAnnouncementEmail: Boolean = false,

    val alwaysMarkNsfw: Boolean = false,

    val autoSensitive: Boolean = false,

    val carefulBot: Boolean = false,

    val autoAcceptFollowed: Boolean = false,

    val noCrawle: Boolean = false,

    val isExplorable: Boolean = false,

    val isDeleted: Boolean = false,

    val hideOnlineStatus: Boolean = false,

    val hasUnreadSpecifiedNotes: Boolean = false,

    val hasUnreadMentions: Boolean = false,

    val hasUnreadMessagingMessage: Boolean? = null,  // removed in v13.9.1

    val hasUnreadAnnouncement: Boolean = false,

    val hasUnreadAntenna: Boolean = false,

    val hasUnreadChannel: Boolean = false,

    val hasUnreadNotification: Boolean = false,

    val hasPendingReceivedFollowRequest: Boolean = false,

    val mutedWords: List<String> = emptyList(),

    val mutedInstances: List<String> = emptyList(),

    val mutingNotificationTypes: List<String> = emptyList(),

    val emailNotificationTypes: List<String> = emptyList(), // todo

    val achievements: List<Achievement> = emptyList(),

    val loggedInDays: Int = 0,

    val email: String? = null,

    val emailVerified: Boolean = false,

    val policies: Policies = Policies(),

    val securityKeysList: List<String> = emptyList()
)
