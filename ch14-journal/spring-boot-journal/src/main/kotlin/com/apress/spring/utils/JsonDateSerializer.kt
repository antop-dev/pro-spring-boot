package com.apress.spring.utils

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class JsonDateSerializer : JsonSerializer<LocalDate>() {
    companion object {
        val FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    }

    override fun serialize(value: LocalDate?, g: JsonGenerator, provider: SerializerProvider) {
        value?.run {
            g.writeString(this.format(FORMATTER))
        }
    }
}
