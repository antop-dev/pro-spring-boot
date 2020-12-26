package com.apress.spring.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "my")
@ConstructorBinding
data class MyProperties(val queue: String = "")
