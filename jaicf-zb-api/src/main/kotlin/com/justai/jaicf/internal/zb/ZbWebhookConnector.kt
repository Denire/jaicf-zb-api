package com.justai.jaicf.internal.zb

import com.justai.jaicf.api.BotApi
import com.justai.jaicf.channel.http.HttpBotRequest
import com.justai.jaicf.channel.http.HttpBotResponse
import com.justai.jaicf.channel.http.asJsonHttpBotResponse
import com.justai.jaicf.channel.jaicp.DEFAULT_PROXY_URL
import com.justai.jaicf.channel.jaicp.JaicpBotChannel
import com.justai.jaicf.channel.jaicp.JaicpChannelFactory
import com.justai.jaicf.channel.jaicp.JaicpCompatibleBotChannel
import com.justai.jaicf.channel.jaicp.JaicpServer
import com.justai.jaicf.channel.jaicp.JaicpWebhookConnector
import com.justai.jaicf.channel.jaicp.dto.ChannelConfig
import com.justai.jaicf.channel.jaicp.endpoints.ktor.channelCheckEndpoint
import com.justai.jaicf.channel.jaicp.endpoints.ktor.healthCheckEndpoint
import com.justai.jaicf.channel.jaicp.endpoints.ktor.reloadConfigEndpoint
import com.justai.jaicf.helpers.logging.WithLogger

/**
 * Processes [HttpBotRequest] with [JaicpCompatibleBotChannel] channels. If [channel] is not given, [ZbChannel] will process request.
 *
 * (!) NOTE:
 *  This implementation creates its own [ZbChannel] inside which has no factory.
 *  If you dont provide a [JaicpChannelFactory] to handle requests, [ZbChannel] will process it.
 *
 * Also note:
 * In general cases, you should use [JaicpServer] to establish webhook connection between JAICP and your bot,
 * as it provides required endpoints: [channelCheckEndpoint], [healthCheckEndpoint], [reloadConfigEndpoint].
 *
 * @param botApi the [BotApi] implementation used to process the requests for all channels
 * @param accessToken can be configured in JAICP Web Interface
 * @param url chatadapter URL
 * @param channels is a list of channels which will be managed by connector. If no channel for channelType is found, zbNative channel will process it.
 * */
class ZbWebhookConnector(
    botApi: BotApi,
    accessToken: String,
    url: String = DEFAULT_PROXY_URL,
    channels: List<JaicpChannelFactory> = emptyList()
) : JaicpWebhookConnector(botApi, accessToken, url, channels),
    WithLogger {

    private val zbChannel: ZbChannel = ZbChannel(botApi)

    override fun process(request: HttpBotRequest): HttpBotResponse? {
        val jaicpBotRequest = request.receiveText().asJaicpBotRequest()
        val channel = channelMap[jaicpBotRequest.channelBotId] ?: zbChannel
        return processJaicpRequest(jaicpBotRequest, channel)?.deserialized()?.asJsonHttpBotResponse()
    }
}
