package com.justai.jaicf.internal.zb

import com.justai.jaicf.channel.jaicp.dto.JaicpBotRequest
import com.justai.jaicf.channel.jaicp.dto.JaicpBotResponse
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration

internal val JSON = Json(JsonConfiguration.Stable.copy(strictMode = false, encodeDefaults = false))

internal fun String.asJaicpBotRequest() = JSON.parse(JaicpBotRequest.serializer(), this)

internal fun JaicpBotResponse.deserialized() = JSON.stringify(JaicpBotResponse.serializer(), this)

