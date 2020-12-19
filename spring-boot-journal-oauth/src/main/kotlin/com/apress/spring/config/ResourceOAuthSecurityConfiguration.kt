package com.apress.spring.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter

@Configuration
@EnableAuthorizationServer
@EnableResourceServer
class ResourceOAuthSecurityConfiguration : ResourceServerConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests { authorize ->
            authorize.antMatchers("/").permitAll()
            authorize.antMatchers("/api/**").authenticated()
        }
    }

}
