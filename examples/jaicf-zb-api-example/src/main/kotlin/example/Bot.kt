package example

import com.justai.jaicf.BotEngine


val bot = BotEngine(scenario.model)
val accessToken = System.getenv("JAICP_API_TOKEN") ?: "some-access-token"
