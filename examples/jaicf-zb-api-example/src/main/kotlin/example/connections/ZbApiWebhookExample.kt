package example.connections


import com.justai.jaicf.channel.jaicp.JaicpServer
import com.justai.jaicf.channel.jaicp.JaicpWebhookConnector
import com.justai.jaicf.channel.telegram.TelegramChannel
import com.justai.jaicf.internal.zb.ZbWebhookConnector
import example.accessToken
import example.bot


/**
 * Creates a JaicpServer, deployable to jaicp-cloud, which uses ZB API for all requests processing
 * */
fun main() {
    object : JaicpServer(bot, accessToken, listOf(TelegramChannel)) {
        override val connector: JaicpWebhookConnector = ZbWebhookConnector(bot, accessToken)
    }.start(wait = true)
}