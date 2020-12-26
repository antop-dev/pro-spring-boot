package com.apress.spring.message

import mu.KotlinLogging
import javax.jms.Message
import javax.jms.MessageListener

class Consumer : MessageListener {
    private val log = KotlinLogging.logger { }

    override fun onMessage(message: Message) {
        val body = message.getBody(Object::class.java)
        log.info { "소비기 > $body" }
    }

}
