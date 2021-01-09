package example

import com.justai.jaicf.channel.jaicp.reactions.switchToOperator
import com.justai.jaicf.internal.zb.reactions.zb
import com.justai.jaicf.internal.zb.zb
import com.justai.jaicf.model.scenario.Scenario
import com.justai.jaicf.reactions.jaicp.jaicpAsync

val scenario = object : Scenario() {
    init {
        state("start") {
            activators {
                regex("/start")
            }
            action {
                reactions.say("Hello there!")
                reactions.buttons("How can I help you?", "What is your name?")
            }
        }

        state("Help") {
            activators {
                intent("Help")
            }
            action {
                reactions.say("I can give you a picture of cat")
                reactions.image("https://www.bluecross.org.uk/sites/default/files/d8/assets/images/118809lprLR.jpg")
            }
        }
        state("Switch") {
            activators {
                regex("switch")
            }
            action(zb) {
                reactions.switch("Hi operator, help me plz.")
            }
        }
        fallback {
            reactions.say("You said: ${request.input}")
        }
    }
}