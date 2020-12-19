package com.apress.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootJournalSecureApplication

fun main(args: Array<String>) {
	runApplication<SpringBootJournalSecureApplication>(*args)
}
