package com.apress.spring.domain

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test

internal class JournalEntryTest {

    @Test
    internal fun name() {
        val mapper = ObjectMapper()
        val journal = JournalEntry("제목", "요약", "2020-12-18")

        println(mapper.writeValueAsString(journal))
    }
}
