package com.apress.spring

import com.apress.spring.config.MyProperties
import com.apress.spring.message.Producer
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.jms.core.JmsTemplate

@SpringBootApplication
@ConfigurationPropertiesScan
class SpringBootJmsApplication(private val properties: MyProperties) {

    @Bean
    fun sendMessage(jmsTemplate: JmsTemplate) = CommandLineRunner() {
        val producer = Producer(jmsTemplate)
        producer.sendTo(properties.queue, "스프링 부트 시작!")
    }

}

fun main(args: Array<String>) {
    runApplication<SpringBootJmsApplication>(*args)
}
