package com.apress.spring.repository

import com.apress.spring.domain.Journal
import org.springframework.data.jpa.repository.JpaRepository

interface JournalRepository : JpaRepository<Journal, Long>
