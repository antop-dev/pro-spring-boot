package com.apress.spring.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import java.sql.ResultSet
import java.sql.Types

@Configuration
@EnableGlobalAuthentication
class JdbcSecurityConfiguration(private val jdbcTemplate: JdbcTemplate) : GlobalAuthenticationConfigurerAdapter() {

    @Bean
    fun userDetailsService() = UserDetailsService { username: String ->
        jdbcTemplate.queryForObject(
            "SELECT * FROM account WHERE account_name = ?",
            arrayOf<Any>(username),
            intArrayOf(Types.VARCHAR)
        ) { rs: ResultSet, _: Int ->
            val enabled = rs.getBoolean("enabled")
            User(
                rs.getString("account_name"),
                rs.getString("password"),
                enabled, enabled, enabled, enabled,
                AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN")
            )
        }
    }

    override fun init(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService())
    }

}


