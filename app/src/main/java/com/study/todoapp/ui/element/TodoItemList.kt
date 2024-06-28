package com.study.todoapp.ui.element

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.study.todoapp.data.TodoItemsRepository

@Composable
fun TodoItemsList(todoItemsRepository: TodoItemsRepository) {
    val repository = remember { mutableStateOf(todoItemsRepository) }
    val list = repository.value.getAllTodoItems()

    LazyColumn (
        modifier = Modifier
            .fillMaxSize()
    )
    {
        items(list.size) {
            TodoItemCell(todoItem = list[it])
        }
    }
}