package com.apress.spring

import com.apress.spring.domain.Journal
import com.apress.spring.repository.JournalRepository
import mu.KotlinLogging
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.time.LocalDate

@SpringBootApplication
class SimpleMongoAppApplication {
    val log = KotlinLogging.logger { }

    @Bean
    fun start(repository: JournalRepository) = CommandLineRunner {
        log.info { "> 기존 데이터 삭제..." }
        repository.deleteAll()

        log.info { "> 데이터를 새로 생성..." }
        repository.save(Journal("스프링 부트 입문", "오늘부터 스프링 부트 공부하기 시작했다", LocalDate.of(2016, 1, 1)))
        repository.save(Journal("간단한 스프링 부트 프로젝트", "스프링 부트 프로젝트를 처음 만들어보았다", LocalDate.of(2016, 1, 2)))
        repository.save(Journal("스프링 부트 해부", "스프링 부트를 자세히 살펴보았다", LocalDate.of(2016, 2, 1)))
        repository.save(Journal("스프링 부트 클라우드", "클라우드 파운드리를 응용한 스프링 부트를 공부했다", LocalDate.of(2016, 2, 1)))

        log.info { "> 전체 데이터 조회..." }
        repository.findAll().forEach {
            log.info { it }
        }

        log.info { "> LIKE로 데이터 조회..." }
        repository.findByTitleLike("클라우드").forEach {
            log.info { it }
        }
    }

}

fun main(args: Array<String>) {
    runApplication<SimpleMongoAppApplication>(*args)
}
