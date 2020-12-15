package com.apress.spring.domain

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Journal(val id: Long, var title: String, var summary: String, val created: LocalDate) {
    companion object {
        val format: DateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
    }

    val createdAsShort: String
        get() = created.format(format)

    override fun toString(): String {
        return "Journal(id=$id, title='$title', summary='$summary', createdAsShort='$createdAsShort')"
    }

}
