package example

import com.justai.jaicf.builder.Scenario
import com.justai.jaicf.internal.zb.zb

val scenario = Scenario {
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