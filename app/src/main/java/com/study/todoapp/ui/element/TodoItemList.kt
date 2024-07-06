package com.study.todoapp.ui.element

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.study.todoapp.R
import com.study.todoapp.data.TodoItemsRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoItemsList(todoItemsRepository: TodoItemsRepository) {
    val list = todoItemsRepository.getAllTodoItems()
    var doneAmount by remember {
        mutableIntStateOf(todoItemsRepository.getAllTodoItems().count { it.isReady })
    }
    var isVisible by remember {
        mutableStateOf(true)
    }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            AppBar(scrollBehavior = scrollBehavior, doneAmount = doneAmount, isVisible = isVisible) {
                isVisible = !isVisible
            }
        }
    ) {

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(3.dp),
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        )
        {
            items(list.size) {
            if (isVisible || !list[it].isReady)
                TodoItemCell(todoItem = list[it], onCheckboxChange = { doneAmount = todoItemsRepository.getAllTodoItems().count { it.isReady }})
            }
        }
    }
}

@Preview
@Composable
fun TodoItemList() {
    TodoItemsList(todoItemsRepository = TodoItemsRepository())
}