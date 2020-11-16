package com.justai.jaicf.internal.zb.reactions

import com.justai.jaicf.channel.jaicp.dto.AudioReply
import com.justai.jaicf.channel.jaicp.dto.Button
import com.justai.jaicf.channel.jaicp.dto.ButtonsReply
import com.justai.jaicf.channel.jaicp.dto.HangupReply
import com.justai.jaicf.channel.jaicp.dto.ImageReply
import com.justai.jaicf.channel.jaicp.dto.Reply
import com.justai.jaicf.channel.jaicp.dto.SwitchReply
import com.justai.jaicf.channel.jaicp.reactions.JaicpReactions
import com.justai.jaicf.context.ActionContext
import com.justai.jaicf.helpers.http.toUrl
import com.justai.jaicf.logging.AudioReaction
import com.justai.jaicf.logging.ButtonsReaction
import com.justai.jaicf.logging.ImageReaction
import com.justai.jaicf.reactions.Reactions


/**
 * Reactions implementations for ZB API. Add your reactions here.
 * */
class ZbReactions : JaicpReactions() {
    override fun audio(url: String): AudioReaction {
        replies.add(AudioReply(url.toUrl()))
        return AudioReaction.create(url)
    }

    fun hangup() {
        replies.add(HangupReply())
    }

    fun transferCall(phoneNumber: String, sipHeaders: Map<String, String> = emptyMap()) {
        replies.add(SwitchReply(phoneNumber, sipHeaders))
    }

    override fun image(url: String): ImageReaction {
        return image(imageUrl = url, caption = null)
    }

    fun image(imageUrl: String, caption: String? = null): ImageReaction {
        replies.add(ImageReply(imageUrl, caption))
        return ImageReaction.create(imageUrl)
    }

    fun button(text: String, transition: String? = null): ButtonsReaction {
        replies.add(ButtonsReply(Button(text, transition)))
        return ButtonsReaction.create(listOf(text))
    }

    override fun buttons(vararg buttons: String): ButtonsReaction {
        return buttons(buttons.asList())
    }

    fun buttons(buttons: List<String>): ButtonsReaction {
        replies.add(ButtonsReply(buttons.map { Button(it) }))
        return ButtonsReaction.create(buttons)
    }

    fun changeContext(path: String) {
        botContext.dialogContext.currentState = path
    }

    fun customReply(reply: Reply){
        replies.add(reply)
    }
}

val Reactions.zb
    get() = this as? ZbReactions
