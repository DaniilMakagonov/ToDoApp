package com.study.todoapp.ui.element

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.study.todoapp.data.TodoItemsRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoItemsList(todoItemsRepository: TodoItemsRepository, navController: NavController) {
    val list = todoItemsRepository.getAll()
    var doneAmount by remember {
        mutableIntStateOf(todoItemsRepository.getAll().count { it.isReady })
    }
    var isVisible by remember {
        mutableStateOf(true)
    }

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            AppBar(
                scrollBehavior = scrollBehavior,
                doneAmount = doneAmount,
                isVisible = isVisible
            ) {
                isVisible = !isVisible
            }
        },
        floatingActionButton = { NewItemButton(navController) }
    ) {

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(3.dp),
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        )
        {
            items(list.size) { ind ->
                if (isVisible || !list[ind].isReady)
                    TodoItemCell(
                        todoItem = list[ind],
                        navController = navController,
                        onCheckboxChange = { todoItem, value ->
                            todoItemsRepository.updateItem(
                                todoItemsRepository.getItem(todoItem.id).copy(isReady = value)
                            )
                            doneAmount =
                                todoItemsRepository.getAll().count { item -> item.isReady }
                        })
            }
        }
    }
}

@Preview
@Composable
fun TodoItemList() {
    TodoItemsList(
        todoItemsRepository = TodoItemsRepository(),
        navController = rememberNavController()
    )
}