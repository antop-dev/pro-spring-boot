package com.apress.spring

import com.apress.spring.redis.Producer
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SpringBootRedisApplication {

    @Value("\${topic}")
    lateinit var tpoic: String

    @Bean
    fun sendMessage(producer: Producer) = CommandLineRunner() {
        producer.sendTo(tpoic, "스프림 부트와 레디스 메시징 시작!")
    }

}

fun main(args: Array<String>) {
    runApplication<SpringBootRedisApplication>(*args)
}
