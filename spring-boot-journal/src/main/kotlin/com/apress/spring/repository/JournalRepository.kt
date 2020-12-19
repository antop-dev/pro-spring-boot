package com.apress.spring.repository

import com.apress.spring.domain.JournalEntry
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate

@RepositoryRestResource(collectionResourceRel = "entry", path = "journal")
interface JournalRepository : JpaRepository<JournalEntry, Long> {

    fun findByCreatedAfter(@Param("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) date: LocalDate): List<JournalEntry>

    fun findByCreatedBetween(
        @Param("after") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) after: LocalDate,
        @Param("before") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) before: LocalDate
    ): List<JournalEntry>

    fun findByTitleContaining(@Param("word") word: String): List<JournalEntry>

    fun findBySummaryContaining(@Param("word") word: String): List<JournalEntry>
}
