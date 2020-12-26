package com.apress.spring.config

import com.apress.spring.redis.Consumer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.listener.PatternTopic
import org.springframework.data.redis.listener.RedisMessageListenerContainer
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter

@Configuration
class RedisConfig {
    @Value("\${topic}")
    lateinit var topic: String

    @Bean
    fun listenerAdapter(consumer: Consumer) = MessageListenerAdapter(consumer, "messageHandler")

    @Bean
    fun container(
        connectionFactory: RedisConnectionFactory,
        listenerAdapter: MessageListenerAdapter
    ) = RedisMessageListenerContainer().apply {
        setConnectionFactory(connectionFactory)
        addMessageListener(listenerAdapter, PatternTopic(topic))
    }
}
