package com.justai.jaicf.internal.zb

import com.justai.jaicf.api.BotApi
import com.justai.jaicf.api.BotRequest
import com.justai.jaicf.channel.jaicp.JaicpCompatibleBotChannel
import com.justai.jaicf.channel.jaicp.channels.JaicpNativeChannel
import com.justai.jaicf.channel.jaicp.dto.JaicpBotRequest
import com.justai.jaicf.channel.jaicp.reactions.JaicpReactions
import com.justai.jaicf.internal.zb.reactions.ZbReactions

/**
 * A channel using ZbReactions with any channelType.
 * */
class ZbChannel(override val botApi: BotApi) : JaicpNativeChannel(botApi), JaicpCompatibleBotChannel {

    override fun createReactions(): JaicpReactions = ZbReactions()

    override fun createRequest(request: JaicpBotRequest) = request
}

val BotRequest.zb
    get() = this as? JaicpBotRequest