package com.apress.spring.repository

import com.apress.spring.domain.Journal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import java.time.LocalDate

interface JournalRepository : JpaRepository<Journal, Long> {

    fun findByTitleContaining(word: String): List<Journal>

    fun findByCreatedAfter(date: LocalDate): List<Journal>

    @Query("select j from Journal j where j.title like %?1%")
    fun findByCustomQuery(word: String): List<Journal>

}
