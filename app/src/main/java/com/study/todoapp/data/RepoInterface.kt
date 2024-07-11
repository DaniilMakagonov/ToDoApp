package com.study.todoapp.data

interface RepoInterface {
    fun getAll(): List<TodoItem>
    fun getItem(id: String): TodoItem
    fun addItem(item: TodoItem)
    fun updateItem(item: TodoItem)
    fun deleteItem(id: String)
    fun getEmptyId(): String
}