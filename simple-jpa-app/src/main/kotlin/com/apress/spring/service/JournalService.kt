package com.apress.spring.service

import com.apress.spring.domain.Journal
import com.apress.spring.repository.JournalRepository
import org.springframework.stereotype.Service

@Service
class JournalService(private val repository: JournalRepository) {

    fun findAll(): List<Journal> = repository.findAll()

}
