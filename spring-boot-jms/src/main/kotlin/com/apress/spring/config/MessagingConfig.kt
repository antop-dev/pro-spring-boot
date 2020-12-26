package com.apress.spring.config

import com.apress.spring.message.Consumer
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jms.listener.DefaultMessageListenerContainer
import javax.jms.ConnectionFactory

@Configuration
class MessagingConfig(
    @Qualifier("jmsConnectionFactory") private val connectionFactory: ConnectionFactory,
    private val properties: MyProperties
) {

    @Bean
    fun messageListener() = DefaultMessageListenerContainer().apply {
        connectionFactory = this@MessagingConfig.connectionFactory
        destinationName = properties.queue
        messageListener = Consumer()
    }

}
