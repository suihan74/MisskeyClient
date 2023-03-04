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

    val hasUnreadAnnouncement: Boolean,

    val hasUnreadAntenna: Boolean,

    val hasUnreadChannel: Boolean,

    val hasUnreadMessagingMessage: Boolean,

    val hasUnreadNotification: Boolean,

    val hasPendingReceivedFollowRequest: Boolean,

    val mutedWords: List<String>,

    val mutedInstances: List<String>,

    val mutingNotificationTypes: List<String>,

    val emailNotificationTypes: List<String>, // todo

    val showTimelineReplies: Boolean,

    val achievements: List<Achievement>,

    val loggedInDays: Int,

    val email: String? = null,

    val emailVerified: Boolean = false,

    val policies: Policies,

    val securityKeysList: List<String> = emptyList()
)

/*
{
  id: '9ath2nko5p',
  name: 'すいはん',
  username: 'suihan74',
  host: null,
  avatarUrl: 'https://nos3.arkjp.net/avatar.webp?url=https%3A%2F%2Fs3.arkjp.net%2Fmisskey%2F05c17c98-6438-42ab-8f0f-d377b6ffb45e.png&avatar=1',
  avatarBlurhash: 'e*J**Yf6~qofa{~qof%3ofM{NFayM{ayWUWBfQafj[xuxuj[bFayWB',
  isBot: false,
  isCat: false,
  emojis: {},
  onlineStatus: 'online',
  badgeRoles: [],
  url: null,
  uri: null,
  createdAt: '2023-02-04T12:04:56.664Z',
  updatedAt: '2023-02-13T15:35:00.587Z',
  lastFetchedAt: null,
  bannerUrl: 'https://s3.arkjp.net/misskey/f85dac3c-31d7-418b-a35c-6ab4b5429fa5.png',
  bannerBlurhash: 'eJBp,@kC8{sp%L_NofD%agxuo}ofoyWVWCE1f8-;f$RjIqjvx[X4af',
  isLocked: false,
  isSilenced: false,
  isSuspended: false,
  description: '自己紹介はありません',
  location: null,
  birthday: '0001-01-01',
  lang: 'ja-JP',
  fields: [],
  followersCount: 2,
  followingCount: 2,
  notesCount: 86,
  pinnedNoteIds: [],
  pinnedNotes: [],
  pinnedPageId: null,
  pinnedPage: null,
  publicReactions: false,
  ffVisibility: 'public',
  twoFactorEnabled: true,
  usePasswordLessLogin: false,
  securityKeys: false,
  roles: [
    {
      id: '9atd2phrx4',
      name: 'New User',
      color: '#f1c40f',
      iconUrl: null,
      description: '登録して1ヶ月未満のユーザーです。\nスパム防止のため一部の機能に制限があります。',
      isModerator: false,
      isAdministrator: false,
    },
  ],
  avatarId: '9ath4ylsj6',
  bannerId: '9b4m6z0v4a',
  isModerator: false,
  isAdmin: false,
  injectFeaturedNote: true,
  receiveAnnouncementEmail: true,
  alwaysMarkNsfw: false,
  autoSensitive: false,
  carefulBot: false,
  autoAcceptFollowed: true,
  noCrawle: true,
  isExplorable: true,
  isDeleted: false,
  hideOnlineStatus: false,
  hasUnreadSpecifiedNotes: false,
  hasUnreadMentions: false,
  hasUnreadAnnouncement: false,
  hasUnreadAntenna: false,
  hasUnreadChannel: false,
  hasUnreadMessagingMessage: false,
  hasUnreadNotification: false,
  hasPendingReceivedFollowRequest: false,
  mutedWords: [],
  mutedInstances: [],
  mutingNotificationTypes: [],
  emailNotificationTypes: [
    'follow',
    'receiveFollowRequest',
    'groupInvited',
  ],
  showTimelineReplies: false,
  achievements: [
    {
      name: 'profileFilled',
      unlockedAt: 1675512406499,
    },
  ],
  loggedInDays: 8,
  policies: {
    gtlAvailable: true,
    ltlAvailable: true,
    canPublicNote: true,
    canInvite: false,
    canManageCustomEmojis: false,
    canHideAds: false,
    driveCapacityMb: 1000,
    pinLimit: 3,
    antennaLimit: 1,
    wordMuteLimit: 200,
    webhookLimit: 1,
    clipLimit: 5,
    noteEachClipsLimit: 50,
    userListLimit: 5,
    userEachUserListsLimit: 20,
    rateLimitFactor: 0.3,
  },
  email: 'suihan742@gmail.com',
  emailVerified: true,
  securityKeysList: [],
}
 */