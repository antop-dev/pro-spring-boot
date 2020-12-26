package com.apress.spring.redis

import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class Consumer {
    val log = KotlinLogging.logger { }

    fun messageHandler(message: String) {
        log.info { "소비기 > $message" }
    }
}
