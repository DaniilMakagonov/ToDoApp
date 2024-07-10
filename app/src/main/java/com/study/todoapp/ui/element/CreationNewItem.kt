package com.study.todoapp.ui.element

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.study.todoapp.data.TodoItemsRepository

@Composable
fun CreationNewItem(repository: TodoItemsRepository) {
    val text = remember { mutableStateOf("Что нужно сделать?") }

    Column {
        Row(horizontalArrangement = Arrangement.SpaceBetween) {
            IconButton(onClick = { /*TODO*/ }) {} // close
            TextButton(onClick = {
//                repository.addTodoItem(TodoItem( )) TODO
            }) { // save
            }
        }
        TextField(
            value = text.value,
            onValueChange = { text.value = it }
        )
    }
}