package com.apress.spring.message

import mu.KotlinLogging
import org.springframework.jms.core.JmsTemplate

class Producer(private val jmsTemplate: JmsTemplate) {
    private val log = KotlinLogging.logger { }

    fun sendTo(queue: String, message: String) {
        jmsTemplate.convertAndSend(queue, message)
        log.info { "생산기 > 메시지 전송" }
    }
}
