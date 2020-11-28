package com.apress.spring.domain

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Journal(var title: String, var summary: String, val created: LocalDate) {
    companion object {
        val format: DateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    val createdAsShort: String
        get() = created.format(format)

    override fun toString(): String {
        return "Journal(id=$id, title='$title', summary='$summary', createdAsShort='$createdAsShort')"
    }

}
