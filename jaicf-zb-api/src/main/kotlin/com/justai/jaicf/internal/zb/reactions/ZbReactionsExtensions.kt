package com.justai.jaicf.internal.zb.reactions

import com.justai.jaicf.reactions.Reactions

/**
 * Example shortcuts to provide reactions without reference to ZB.
 * */

fun Reactions.hangup() = zb?.hangup()

fun Reactions.transferCall(phoneNumber: String, sipHeaders: Map<String, String> = emptyMap()) = zb?.transferCall(phoneNumber, sipHeaders)