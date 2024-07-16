package com.study.todoapp.data

import java.time.LocalDate

data class TodoItem(
    val id: String,
    val text: String,
    val importance: Importance,
    val isReady: Boolean = false,
    val creationDate: LocalDate = LocalDate.now(),
    val deadline: LocalDate? = null,
    val lastChangeDate: LocalDate = creationDate
)