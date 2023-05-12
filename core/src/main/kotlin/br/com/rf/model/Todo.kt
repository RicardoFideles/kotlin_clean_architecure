package br.com.rf.model

import java.time.LocalDate

data class Todo(
    val id: Long? = null,
    val description: String,
    val created: LocalDate,
)