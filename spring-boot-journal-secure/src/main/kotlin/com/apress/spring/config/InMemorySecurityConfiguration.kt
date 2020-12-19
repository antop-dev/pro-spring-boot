package com.apress.spring.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication

@Configuration
@EnableGlobalAuthentication
class InMemorySecurityConfiguration {

    @Autowired
    fun configureGlobal(auth: AuthenticationManagerBuilder) {
        auth.inMemoryAuthentication()
            .withUser("user")
            // https://blusky10.tistory.com/411
            // https://java.ihoney.pe.kr/498
            .password("{noop}password")
            .roles("USER")
            .and()
            .withUser("admin")
            .password("{noop}password")
            .roles("USER", "ADMIN")
    }

}
