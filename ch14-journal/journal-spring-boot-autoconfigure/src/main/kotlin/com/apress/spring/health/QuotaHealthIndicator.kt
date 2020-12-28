package com.apress.spring.health

import com.apress.spring.repository.JournalRepository
import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.stereotype.Component

@Component
class QuotaHealthIndicator(private val repository: JournalRepository) : HealthIndicator {
    companion object {
        const val KEY = "quota.entries"
        const val QUOTA_MAX_SIZE = 10L
    }

    override fun health(): Health = with(repository.count()) {
        if (this <= QUOTA_MAX_SIZE) Health.up().withDetail(KEY, this).build()
        else Health.down().withDetail(KEY, this).withException(QuotaException(QUOTA_MAX_SIZE)).build()
    }
}
