package com.justai.jaicf.internal.zb

import com.justai.jaicf.api.BotApi
import com.justai.jaicf.channel.jaicp.DEFAULT_PROXY_URL
import com.justai.jaicf.channel.jaicp.JaicpBotChannel
import com.justai.jaicf.channel.jaicp.JaicpChannelFactory
import com.justai.jaicf.channel.jaicp.JaicpPollingConnector
import com.justai.jaicf.channel.jaicp.dto.JaicpBotRequest
import com.justai.jaicf.channel.jaicp.dto.JaicpBotResponse
import com.justai.jaicf.helpers.logging.WithLogger

class ZbPollingConnector(
    botApi: BotApi,
    accessToken: String,
    url: String = DEFAULT_PROXY_URL,
    channels: List<JaicpChannelFactory> = emptyList()
) : JaicpPollingConnector(botApi, accessToken, url, channels),
    WithLogger {

    private val channel: ZbChannel = ZbChannel(botApi)

    override fun processJaicpRequest(request: JaicpBotRequest, channel: JaicpBotChannel): JaicpBotResponse? {
        return this.channel.process(request)
    }
}