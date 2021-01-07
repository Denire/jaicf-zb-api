package example.connections


import com.justai.jaicf.channel.jaicp.channels.ChatWidgetChannel
import com.justai.jaicf.internal.zb.ZbPollingConnector
import com.justai.jaicf.internal.zb.channels.polling.*
import example.accessToken
import example.bot


fun main() {
    ZbPollingConnector(
        bot,
        accessToken,
        channels = listOf(ChatWidgetChannel, AimyboxChannel, VKChannel)
    ).runBlocking()
}