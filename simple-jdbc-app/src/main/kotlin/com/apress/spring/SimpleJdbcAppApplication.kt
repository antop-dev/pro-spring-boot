package com.apress.spring

import com.apress.spring.service.JournalService
import mu.KotlinLogging
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleJdbcAppApplication(private val service: JournalService) : CommandLineRunner {
    private val log = KotlinLogging.logger {}

    // 스프링 부트 시동이 끝나면 실행됨
    override fun run(vararg args: String?) {
        log.info { "@@데이터 생성 ...." }
        service.insertData()
        log.info { "@@ findAll() 호출..." }
        service.findAll().forEach {
            log.info { it }
        }
    }
}

fun main(args: Array<String>) {
    runApplication<SimpleJdbcAppApplication>(*args)
}
