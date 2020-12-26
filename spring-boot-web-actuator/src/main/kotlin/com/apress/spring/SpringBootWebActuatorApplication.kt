package com.apress.spring

import com.apress.spring.repository.PersonRepository
import io.micrometer.core.annotation.Timed
import mu.KotlinLogging
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@SpringBootApplication
class SpringBootWebActuatorApplication() {
    val log = KotlinLogging.logger { }


    @GetMapping("/")
    // https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-metrics-spring-mvc
    @Timed(value = "counter.index.invoked", longTask = true)
    fun index() = "스프링 부트 액추에이터"

    @Bean
    fun findAll(repository: PersonRepository) = CommandLineRunner() {
        log.info { "> DB에서 조회한 Persons:" }
        repository.findAll().forEach { person -> log.info { person } }
    }
}

fun main(args: Array<String>) {
    runApplication<SpringBootWebActuatorApplication>(*args)
}
