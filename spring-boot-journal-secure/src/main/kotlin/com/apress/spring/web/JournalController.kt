package com.apress.spring.web

import com.apress.spring.repository.JournalRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.servlet.ModelAndView

@Controller
class JournalController(private val repository: JournalRepository) {
    companion object {
        const val VIEW_INDEX = "index"
        const val VIEW_LOGIN = "login"
    }

    @GetMapping("/")
    fun index(mav: ModelAndView) = run {
        mav.viewName = VIEW_INDEX
        mav.addObject("journal", repository.findAll())
    }

    @GetMapping("/login")
    fun login(mav: ModelAndView) = run {
        mav.viewName = VIEW_LOGIN
    }

}
