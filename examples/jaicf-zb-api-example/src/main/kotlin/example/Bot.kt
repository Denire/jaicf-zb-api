package example

import com.justai.jaicf.BotEngine
import com.justai.jaicf.activator.regex.RegexActivator
import com.justai.jaicf.logging.Slf4jConversationLogger


val accessToken = System.getenv("JAICP_API_TOKEN") ?: "some-access-token"


val bot = BotEngine(
    model = scenario.model,
    conversationLoggers = arrayOf(
        Slf4jConversationLogger()
    ),
    activators = arrayOf(RegexActivator),
)
