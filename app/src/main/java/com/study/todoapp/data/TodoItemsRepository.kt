package com.study.todoapp.data

import java.time.LocalDate

class TodoItemsRepository : RepoInterface {
    private var emptyId = 10UL
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
        ),
        "2" to TodoItem(
            id = "2",
            text = "Очень оригинальный текст 2",
            importance = Importance.Low,
            isReady = true,
            creationDate = LocalDate.now(),
            deadline = LocalDate.now().plusDays(3)
        ),
        "3" to TodoItem(
            id = "3",
            text = "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3",
            importance = Importance.Normal,
            isReady = true,
            creationDate = LocalDate.now()
        ),
        "4" to TodoItem(
            id = "4",
            text = "Очень оригинальный текст 4" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3",
            importance = Importance.High,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        "5" to TodoItem(
            id = "5",
            text = "Очень оригинальный текст 5",
            importance = Importance.Low,
            isReady = false,
            creationDate = LocalDate.now(),
            deadline = LocalDate.now().plusDays(50)
        ),
        "6" to TodoItem(
            id = "6",
            text = "Очень оригинальный текст 6",
            importance = Importance.Low,
            isReady = true,
            creationDate = LocalDate.now(),
            deadline = LocalDate.now().plusDays(10)
        ),
        "7" to TodoItem(
            id = "7",
            text = "Очень оригинальный текст 7" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3",
            importance = Importance.High,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        "8" to TodoItem(
            id = "8",
            text = "Очень оригинальный текст 8" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3" +
                    "Очень оригинальный текст 3",
            importance = Importance.Low,
            isReady = true,
            creationDate = LocalDate.now()
        ),
        "9" to TodoItem(
            id = "9",
            text = "Очень оригинальный текст 1",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now(),
            deadline = LocalDate.now().plusDays(5)
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
        todoItemsList[item.id] = item
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