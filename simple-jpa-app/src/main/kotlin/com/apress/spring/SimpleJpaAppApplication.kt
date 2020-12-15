package com.apress.spring

import com.apress.spring.service.JournalService
import mu.KotlinLogging
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class SimpleJpaAppApplication {
    private val log = KotlinLogging.logger {}

    @Bean
    fun start(service: JournalService) = CommandLineRunner {
        log.info { "@@ findAll() 호출..." }
        service.findAll().forEach {
            log.info { it }
        }
    }

}

fun main(args: Array<String>) {
    runApplication<SimpleJpaAppApplication>(*args)
}
