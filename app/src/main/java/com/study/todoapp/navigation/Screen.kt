package com.study.todoapp.navigation

sealed class Screen(val route: String) {
    data object MainScreen : Screen("main")
    data object NewItem : Screen("new_item")

    fun withArgs(vararg args: String) = buildString {
        append(route)
        args.forEach { arg ->
            append("?id=$arg")
        }
    }
}