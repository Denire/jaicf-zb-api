package com.justai.jaicf.internal.zb

import com.fasterxml.jackson.annotation.JsonAutoDetect
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.PropertyAccessor
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.databind.node.ObjectNode
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.justai.jaicf.channel.jaicp.dto.JaicpBotRequest
import com.justai.jaicf.channel.jaicp.dto.JaicpBotResponse
import kotlinx.serialization.json.Json

val KotlinxSerializer = Json { encodeDefaults = true; isLenient = true; ignoreUnknownKeys = true }

internal fun String.asJaicpBotRequest() = KotlinxSerializer.decodeFromString(JaicpBotRequest.serializer(), this)

internal fun JaicpBotResponse.deserialized() = KotlinxSerializer.encodeToString(JaicpBotResponse.serializer(), this)

object JacksonObjectMapper {
    val mapper = ObjectMapper()

    init {
        mapper.registerModule(KotlinModule())
        mapper.enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)
        mapper.enable(JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)
        mapper.enable(JsonParser.Feature.ALLOW_COMMENTS)
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        mapper.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
        mapper.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, false)
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE)
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
    }

    fun parse(json: String) = mapper.readTree(json)

    inline fun <reified T> parse(json: String): T = mapper.readValue(json, T::class.java)

    fun <T> parse(json: String, clazz: Class<T>): T = mapper.readValue(json, clazz)

    fun <T> parseNullable(json: String?, clazz: Class<T>): T? = json?.let { mapper.readValue(json, clazz) }

    fun <T> parse(json: String, tr: TypeReference<T>): T = mapper.readValue(json, tr)

    inline fun <reified T> parse(json: JsonNode): T = mapper.treeToValue(json, T::class.java)

    fun <T> parse(json: JsonNode, clazz: Class<T>): T = mapper.treeToValue(json, clazz)

    fun <T> stringify(data: T): String = mapper.writeValueAsString(data)

    fun <T> stringifyNullable(data: T?): String? = data?.let { mapper.writeValueAsString(data) }

    fun toNode(data: Any): JsonNode = mapper.valueToTree(data)

    fun toObject(data: Any): ObjectNode =
        mapper.valueToTree(data)

    fun objectNode() = mapper.createObjectNode()
}

