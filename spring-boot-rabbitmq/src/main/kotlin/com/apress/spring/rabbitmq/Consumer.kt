package com.apress.spring.rabbitmq

import mu.KotlinLogging
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Component

@Component
class Consumer {
    val log = KotlinLogging.logger { }

    @RabbitListener(queues = ["\${myqueue}"])
    fun handler(message: String) {
        log.info("소비기 > $message")
    }
}
