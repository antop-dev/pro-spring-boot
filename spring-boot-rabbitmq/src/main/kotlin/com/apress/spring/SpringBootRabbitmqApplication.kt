package com.apress.spring

import com.apress.spring.rabbitmq.Producer
import org.springframework.amqp.core.Queue
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import java.time.LocalDateTime

@EnableScheduling
@SpringBootApplication
class SpringBootRabbitmqApplication(private val producer: Producer) {

    @Value("\${myqueue}")
    lateinit var queue: String

    @Bean
    fun queue() = Queue(queue, false)

    @Scheduled(fixedDelay = 500L)
    fun sendMessages() {
        producer.sendTo(queue, "안녕하세요, 여러분! 지금 시각은 " + LocalDateTime.now())
    }

}

fun main(args: Array<String>) {
    runApplication<SpringBootRabbitmqApplication>(*args)
}
