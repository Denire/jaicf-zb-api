package example

import com.justai.jaicf.channel.jaicp.dto.Reply
import com.justai.jaicf.internal.zb.JSON
import com.justai.jaicf.internal.zb.reactions.zb
import com.justai.jaicf.reactions.Reactions

/**
 * This example shows how to add custom reply in ZbResponse;
 * */
data class CustomZbReply(
    val field0: String,
    val field1: String
) : Reply("example") {
    override fun serialized() = JSON.stringify(this)
}

fun Reactions.customZbReaction(reply: CustomZbReply) {
    this.zb?.customReply(reply)
}