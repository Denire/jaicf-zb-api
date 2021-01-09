package com.justai.jaicf.internal.zb

import com.justai.jaicf.api.BotApi
import com.justai.jaicf.channel.jaicp.DEFAULT_PROXY_URL
import com.justai.jaicf.channel.jaicp.JaicpBotChannel
import com.justai.jaicf.channel.jaicp.JaicpChannelFactory
import com.justai.jaicf.channel.jaicp.JaicpPollingConnector
import com.justai.jaicf.channel.jaicp.dto.JaicpBotRequest
import com.justai.jaicf.channel.jaicp.dto.JaicpBotResponse
import com.justai.jaicf.helpers.logging.WithLogger
import io.ktor.client.features.logging.*

class ZbPollingConnector(
    botApi: BotApi,
    accessToken: String,
    url: String = DEFAULT_PROXY_URL,
    channels: List<JaicpChannelFactory> = emptyList(),
    logLevel: LogLevel = LogLevel.BODY
) : JaicpPollingConnector(botApi, accessToken, url, channels, logLevel),
    WithLogger {

    private val channel: ZbChannel = ZbChannel(botApi)

    override fun processJaicpRequest(request: JaicpBotRequest, channel: JaicpBotChannel): JaicpBotResponse? {
        return try {
            this.channel.process(request)
        } catch (t: Throwable) {
            logger.warn("", t)
            null
        }

    }
}