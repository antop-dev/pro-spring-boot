package com.apress.spring

import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.jms.annotation.JmsListener
import org.springframework.jms.core.JmsTemplate
import org.springframework.messaging.handler.annotation.SendTo

@SpringBootApplication
@ConfigurationPropertiesScan
class SpringBootJmsV2Application() {
    val log = KotlinLogging.logger { }

    @JmsListener(destination = "\${my.queue}")
    @SendTo("\${my.other-queue}")
    fun simplerConsumer(message: String): String {
        log.info { "간단한 소비기 > $message" }
        return "$message 와 스프링 메시징을 시작!"
    }

    @JmsListener(destination = "\${my.other-queue}")
    fun anotherSimplerConsumer(message: String) {
        log.info { "다른 간단한 소비기 > $message" }
    }

    @Value("\${my.queue}")
    lateinit var queue: String

    @Bean
    fun start(template: JmsTemplate) = CommandLineRunner() {
        log.info { "전송 > ..." }
        template.convertAndSend(queue, "스프링 부트 시작!")
    }

}

fun main(args: Array<String>) {
    runApplication<SpringBootJmsV2Application>(*args)
}
