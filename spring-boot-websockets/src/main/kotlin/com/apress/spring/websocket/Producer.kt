package com.apress.spring.websocket

import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class Producer(private val template: SimpMessagingTemplate) {
    companion object {
        const val PREFIX = "/topic"
    }

    val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")

    fun sendMessageTo(topic: String, message: String) {
        val payload = "[${LocalDateTime.now().format(dateTimeFormatter)}] $message"
        template.convertAndSend("$PREFIX/$topic", payload)
    }

}
