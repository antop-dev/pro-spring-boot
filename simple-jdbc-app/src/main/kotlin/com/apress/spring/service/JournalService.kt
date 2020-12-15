package com.apress.spring.service

import com.apress.spring.domain.Journal
import mu.KotlinLogging
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import java.sql.ResultSet

@Service
class JournalService(private val jdbcTemplate: JdbcTemplate) {
    private val log = KotlinLogging.logger {}

    fun insertData() {
        log.info { "> 테이블 생성" }
        jdbcTemplate.execute("DROP TABLE JOURNAL IF EXISTS")
        jdbcTemplate.execute("""
            CREATE TABLE JOURNAL (
                id SERIAL,
                title VARCHAR(255),
                summary VARCHAR(255),
                created TIMESTAMP
            )
            """.trimIndent()
        )
        log.info { "> 데이터 생성..." }
        jdbcTemplate.execute("""
            INSERT INTO JOURNAL (title, summary, created)
            VALUES ('스프링 부트 입문', '오늘부터 스프링 부트를 배웠다', '2016-01-02 00:00:00.00')
            """.trimIndent()
        )
        jdbcTemplate.execute("""
            INSERT INTO JOURNAL (title, summary, created)
            VALUES ('간단한 스프링 부트 프로젝트', '스프링 부트 프로젝트를 처음으로 만들어보았다', '2016-01-03 00:00:00.00')
            """.trimIndent()
        )
        jdbcTemplate.execute("""
            INSERT INTO JOURNAL (title, summary, created)
            VALUES ('스프링 부트 해부', '스프링 부트를 자세히 살펴보았다', '2016-02-02 00:00:00.00')
            """.trimIndent()
        )
        jdbcTemplate.execute("""
            INSERT INTO JOURNAL (title, summary, created)
            VALUES ('스프링 부트 클라우드', '클라우드 파운드리를 응용한 스프링 부트를 공부했다', '2016-02-05 00:00:00.00')
            """.trimIndent()
        )
        log.info { "> 완료" }
    }

    fun findAll(): List<Journal> {
        return jdbcTemplate.query("SELECT * FROM JOURNAL") { rs: ResultSet, _: Int ->
            Journal(
                    id = rs.getLong("id"),
                    title = rs.getString("title"),
                    summary = rs.getString("summary"),
                    created = rs.getDate("created").toLocalDate()
            )
        }
    }

}
