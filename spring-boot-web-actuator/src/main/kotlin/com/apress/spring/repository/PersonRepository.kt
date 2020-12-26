package com.apress.spring.repository

import com.apress.spring.domain.Person
import org.springframework.data.repository.CrudRepository

interface PersonRepository : CrudRepository<Person, Long>
