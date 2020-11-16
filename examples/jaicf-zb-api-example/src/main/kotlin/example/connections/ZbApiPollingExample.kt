package example.connections


import com.justai.jaicf.api.BotApi
import com.justai.jaicf.channel.jaicp.JaicpChannelFactory
import com.justai.jaicf.channel.jaicp.JaicpCompatibleBotChannel
import com.justai.jaicf.channel.jaicp.JaicpCompatibleChannelFactory
import com.justai.jaicf.channel.jaicp.channels.ChatWidgetChannel
import com.justai.jaicf.internal.zb.ZbChannel
import com.justai.jaicf.internal.zb.ZbPollingConnector
import example.accessToken
import example.bot

/**
 * Example usages how to set up a polling for channel without api implementation.
 * */
object VKPollingChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "vk"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

/**
 * Example usages how to set up a polling for channel without api implementation.
 * */
object AimyboxPollingChannel : JaicpCompatibleChannelFactory {
    override val channelType: String = "zenbox"
    override fun create(botApi: BotApi): JaicpCompatibleBotChannel = ZbChannel(botApi)
}

/**
 * */
fun main() {
    ZbPollingConnector(
        bot,
        accessToken,
        channels = listOf(ChatWidgetChannel, AimyboxPollingChannel, VKPollingChannel)
    ).runBlocking()
}