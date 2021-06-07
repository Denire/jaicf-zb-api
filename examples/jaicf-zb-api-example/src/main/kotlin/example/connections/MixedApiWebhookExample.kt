package example.connections

import com.justai.jaicf.channel.jaicp.JaicpServer
import com.justai.jaicf.channel.jaicp.JaicpWebhookConnector
import com.justai.jaicf.channel.jaicp.channels.ChatWidgetChannel
import com.justai.jaicf.internal.zb.ZbWebhookConnector
import example.accessToken
import example.bot


/**
 * Creates a JaicpServer, deployable to jaicp-cloud,
 * which uses ZB API for all requests processing, except channels explicitly listed in ZbWebhookConnector.
 * */
fun main() {
    val channels = listOf(ChatWidgetChannel)
    object : JaicpServer(bot, accessToken, channels) {
        override val connector: JaicpWebhookConnector = ZbWebhookConnector(bot, accessToken, nativeChannels = channels)
    }.start(wait = true)
}