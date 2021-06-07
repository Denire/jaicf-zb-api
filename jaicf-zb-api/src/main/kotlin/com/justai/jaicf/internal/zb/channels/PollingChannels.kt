@file:Suppress("unused")

package com.justai.jaicf.internal.zb.channels

import com.justai.jaicf.api.BotApi
import com.justai.jaicf.channel.jaicp.JaicpCompatibleBotChannel
import com.justai.jaicf.channel.jaicp.JaicpCompatibleChannelFactory
import com.justai.jaicf.internal.zb.ZbChannel

object VKChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "vk"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object AimyboxChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "zenbox"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object YandexChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "yandex"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object AzureChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "azure"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object ViberChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "viber"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object SberChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "sber"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object MarusiaChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "marusia"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object OdnoklassnikiChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "odnoklassniki"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object ThreadsChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "threads"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object WechatChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "wechat"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object NexmoChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "nexmo"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object IDigitalChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "i_digital"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object MFMSChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "mfms"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object LiveTexPrompterChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "levetex_prompter"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object ZendeskChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "zendesk"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object WebimChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "webim"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object Webim2Channel : JaicpCompatibleChannelFactory {
    override val channelType: String = "webim2"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object BitrixChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "bitrix"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object Chat2DeskChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "chat2desk"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

object JivositeChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "incoming_jivosite"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}
