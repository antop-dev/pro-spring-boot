package com.apress.spring.web

import com.apress.spring.websocket.Producer
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class WebSocketController(private val producer: Producer) {

    @PostMapping("/send/{topic}")
    fun sender(@PathVariable topic: String, @RequestParam message: String): String {
        producer.sendMessageTo(topic, message)
        return "OK - 전송됨"
    }

}
