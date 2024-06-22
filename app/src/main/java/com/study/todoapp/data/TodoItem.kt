package com.study.todoapp.data

import java.time.LocalDate

data class TodoItem(
    val id : String,
    var text : String,
    var importance: Importance,
    var isReady : Boolean,
    val creationDate : LocalDate,
    var deadline : LocalDate? = null,
    var lastChangeDate: LocalDate? = null
)