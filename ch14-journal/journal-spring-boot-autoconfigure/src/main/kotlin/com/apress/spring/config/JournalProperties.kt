package com.apress.spring.config

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "journal")
class JournalProperties {
    companion object {
        const val DEFAULT_CONTEXT_PATH = "/spring-boot-journal"
        const val DEFAULT_API_PATH = "/api"
    }

    /**
     * 컨텍스트 패스
     */
    var contextPath = DEFAULT_CONTEXT_PATH

    /**
     * 매너 파일 위치
     */
    var banner: String? = null

    /**
     * API 패스
     */
    var apiPath: String = DEFAULT_API_PATH
}
