package com.apress.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootWebsocketsApplication

fun main(args: Array<String>) {
	runApplication<SpringBootWebsocketsApplication>(*args)
}
