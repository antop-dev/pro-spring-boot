package com.apress.spring

import com.apress.spring.config.JournalProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView

@SpringBootApplication
@RestController
class SpringBootCalendarApplication(private val journal: JournalProperties) {
    companion object {
        const val VIEW_INDEX = "index"
    }

    @GetMapping("/")
    fun index(mav: ModelAndView): ModelAndView {
        return mav.apply {
            viewName = VIEW_INDEX
            addObject("journal", journal)
        }
    }

}

fun main(args: Array<String>) {
    runApplication<SpringBootCalendarApplication>(*args)
}
