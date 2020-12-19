package com.apress.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootJournalApplication

fun main(args: Array<String>) {
    runApplication<SpringBootJournalApplication>(*args)
}
