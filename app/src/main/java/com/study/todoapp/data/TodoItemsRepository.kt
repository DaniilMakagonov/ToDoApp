package com.study.todoapp.data

import java.time.LocalDate

class TodoItemsRepository : RepoInterface {
    private var emptyId = 2UL
    private val todoItemsList = mutableMapOf(
        "0" to TodoItem(
            id = "0",
            text = "Очень оригинальный текст 0",
            importance = Importance.High,
            isReady = false,
            creationDate = LocalDate.now(),
            deadline = LocalDate.now().plusDays(5)
        ),
        "1" to TodoItem(
            id = "1",
            text = "Очень оригинальный текст 1",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        )
    )

    override fun addItem(item: TodoItem) {
        if (item.id.toULong() >= emptyId) {
            todoItemsList[item.id] = item
            emptyId = item.id.toULong() + 1UL
        } else {
            todoItemsList[emptyId.toString()] = TodoItem(
                id = emptyId.toString(),
                text = item.text,
                importance = item.importance,
                isReady = item.isReady,
                creationDate = item.creationDate,
                deadline = item.deadline,
                lastChangeDate = item.lastChangeDate
            )
            ++emptyId
        }
    }

    override fun updateItem(item: TodoItem) {
        val updatedItem = getItem(item.id)
        updatedItem.text = item.text
        updatedItem.importance = item.importance
        updatedItem.deadline = item.deadline
        updatedItem.lastChangeDate = item.lastChangeDate
    }

    override fun getAll(): List<TodoItem> = todoItemsList.map { it.value.copy() }

    override fun getItem(id: String): TodoItem {
        return todoItemsList[id]!!.copy()
    }

    override fun deleteItem(id: String) {
        todoItemsList.remove(id)
    }

    override fun getEmptyId() = emptyId.toString()
}