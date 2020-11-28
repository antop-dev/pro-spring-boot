package com.apress.spring.web

import com.apress.spring.domain.Journal
import com.apress.spring.repository.JournalRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class JournalController(private val repository: JournalRepository) {

    @GetMapping("/journal")
    @ResponseBody
    fun getJournal(): MutableList<Journal> = repository.findAll()

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute("journal", repository.findAll())
        return "index"
    }

}
