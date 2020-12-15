package com.apress.spring.domain

import org.springframework.data.annotation.Id
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class Journal(var title: String, var summary: String, val created: LocalDate) {
    companion object {
        val FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
    }

    /**
     * val로 선언하면
     * No accessor to set property @org.springframework.data.annotation.Id()private final java.lang.String com.apress.spring.domain.Journal.id!
     */
    @Id
    var id: String = ""

    val createdAsShort: String
        get() = created.format(FORMATTER)

    override fun toString(): String {
        return "Journal(id=$id, title='$title', summary='$summary', createdAsShort='$createdAsShort')"
    }

}
