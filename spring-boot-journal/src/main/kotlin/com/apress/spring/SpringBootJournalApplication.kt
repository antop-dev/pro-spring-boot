package com.apress.spring

import com.apress.spring.domain.Journal
import com.apress.spring.repository.JournalRepository
import org.springframework.beans.factory.InitializingBean
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.time.LocalDate

@SpringBootApplication
class SpringBootJournalApplication {
    @Bean
    fun saveData(repository: JournalRepository): InitializingBean {
        return InitializingBean {
            repository.save(Journal("스프링 부트 입문", "오늘부터 스프링 부트 공부하기 시작했다", LocalDate.of(2016, 1, 1)))
            repository.save(Journal("간단한 스프링 부트 프로젝트", "스프링 부트 프로젝트를 처음 만들어보았다", LocalDate.of(2016, 1, 2)))
            repository.save(Journal("스프링 부트 해부", "스프링 부트를 자세히 살펴보았다", LocalDate.of(2016, 2, 1)))
            repository.save(Journal("스프링 부트 클라우드", "클라우드 파운드리를 응용한 스프링부트를 공부했다", LocalDate.of(2016, 3, 1)))
        }
    }
}

fun main(args: Array<String>) {
    runApplication<SpringBootJournalApplication>(*args)
}
