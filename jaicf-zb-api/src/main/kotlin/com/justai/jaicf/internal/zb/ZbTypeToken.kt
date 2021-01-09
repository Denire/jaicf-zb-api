package com.justai.jaicf.internal.zb

import com.justai.jaicf.channel.jaicp.dto.JaicpBotRequest
import com.justai.jaicf.generic.ChannelTypeToken
import com.justai.jaicf.internal.zb.reactions.ZbReactions

typealias ZbTypeToken = ChannelTypeToken<JaicpBotRequest, ZbReactions>

val zb: ZbTypeToken = ChannelTypeToken()