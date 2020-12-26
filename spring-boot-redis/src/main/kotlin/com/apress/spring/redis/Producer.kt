package com.apress.spring.redis

import mu.KotlinLogging
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.stereotype.Component

@Component
class Producer(private val template: StringRedisTemplate) {
    val log = KotlinLogging.logger {  }

    fun sendTo(topic: String, message: String) {
        log.info { "전송 > ..." }
        template.convertAndSend(topic, message)
    }

}
