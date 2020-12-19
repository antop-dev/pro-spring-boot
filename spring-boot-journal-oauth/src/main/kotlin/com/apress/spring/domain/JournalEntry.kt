package com.apress.spring.domain

import com.apress.spring.utils.JsonDateSerializer
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.persistence.*

@Entity
@Table(name = "entry")
class JournalEntry(
    val title: String,
    val summary: String,
    created: String
) {
    companion object {
        val FORMATTER: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
        private set

    @JsonSerialize(using = JsonDateSerializer::class)
    val created: LocalDate = LocalDate.parse(created, FORMATTER)

    val createdAsShort: String
        @JsonIgnore
        get() = created.format(FORMATTER)

    override fun toString(): String {
        return "JournalEntry(id=$id, title='$title', summary='$summary', created=$created)"
    }

}
