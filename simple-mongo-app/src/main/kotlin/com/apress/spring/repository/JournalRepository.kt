package com.apress.spring.repository

import com.apress.spring.domain.Journal
import org.springframework.data.mongodb.repository.MongoRepository

interface JournalRepository : MongoRepository<Journal, String> {

    fun findByTitleLike(word: String): List<Journal>

}
