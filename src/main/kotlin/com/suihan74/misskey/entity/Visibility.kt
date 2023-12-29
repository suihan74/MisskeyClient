package com.suihan74.misskey.entity

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * ノートの公開範囲
 */
@Serializable(with = VisibilitySerializer::class)
enum class Visibility(val value: String) {
    /**
     * 全てのユーザーに公開
     */
    Public("public"),

    /**
     * ホームタイムラインのみに公開
     */
    Home("home"),

    /**
     * 自分のフォロワーのみに公開
     */
    Followers("followers"),

    /**
     * 指定したユーザーのみに公開
     */
    Specified("private")
}

// ------ //

/**
 * [Visibility]をAPIパラメータ用の文字列に変換する シリアライザ
 */
internal class VisibilitySerializer : KSerializer<Visibility> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor(this::class.qualifiedName!!, PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Visibility) {
        encoder.encodeString(value.value)
    }

    override fun deserialize(decoder: Decoder): Visibility {
        return decoder.decodeString().let { decoded ->
            Visibility.values().first { it.value == decoded }
        }
    }
}