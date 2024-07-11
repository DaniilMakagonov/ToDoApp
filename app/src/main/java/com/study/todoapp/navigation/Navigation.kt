package com.study.todoapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.study.todoapp.data.TodoItemsRepository
import com.study.todoapp.ui.element.NewItemScreen
import com.study.todoapp.ui.element.TodoItemsList

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val repository = TodoItemsRepository()
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(route = Screen.MainScreen.route) {
            TodoItemsList(
                todoItemsRepository = repository,
                navController = navController
            )
        }
        composable(
            route = Screen.NewItem.route + "?id={id}",
            arguments = listOf(
                navArgument(name = "id") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                }
            )
        ) { entry ->

            NewItemScreen(
                repository = repository,
                id = entry.arguments?.getString("id"),
                navController = navController
            )
        }
    }
}