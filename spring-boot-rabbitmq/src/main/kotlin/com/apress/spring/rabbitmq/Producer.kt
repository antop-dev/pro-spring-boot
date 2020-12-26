package com.apress.spring.rabbitmq

import mu.KotlinLogging
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Component

@Component
class Producer(private val rabbitTemplate: RabbitTemplate) {
    val log = KotlinLogging.logger { }

    fun sendTo(routingKey: String, message: String) {
        log.info { "전송 > ..." }
        rabbitTemplate.convertAndSend(routingKey, message)
    }
}
