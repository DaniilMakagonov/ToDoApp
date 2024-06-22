package com.study.todoapp.data

import java.time.LocalDate

class TodoItemsRepository {
    private val todoItemsList = mutableListOf<TodoItem>(
        TodoItem(
            id = "0",
            text = "Очень оригинальный текст 0",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "1",
            text = "Очень оригинальный текст 1",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "2",
            text = "Очень оригинальный текст 2",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "3",
            text = "Очень оригинальный текст 3",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "4",
            text = "Очень оригинальный текст 4",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "5",
            text = "Очень оригинальный текст 5",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "6",
            text = "Очень оригинальный текст 6",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "7",
            text = "Очень оригинальный текст 7",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "8",
            text = "Очень оригинальный текст 8",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "9",
            text = "Очень оригинальный текст 9",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "10",
            text = "Очень оригинальный текст 10",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "11",
            text = "Очень оригинальный текст 11",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "12",
            text = "Очень оригинальный текст 12",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "13",
            text = "Очень оригинальный текст 13",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "14",
            text = "Очень оригинальный текст 14",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "15",
            text = "Очень оригинальный текст 15",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "16",
            text = "Очень оригинальный текст 16",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "17",
            text = "Очень оригинальный текст 17",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "18",
            text = "Очень оригинальный текст 18",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "19",
            text = "Очень оригинальный текст 19",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "20",
            text = "Очень оригинальный текст 20",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "21",
            text = "Очень оригинальный текст 21",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "22",
            text = "Очень оригинальный текст 22",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "23",
            text = "Очень оригинальный текст 23",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "24",
            text = "Очень оригинальный текст 24",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        ),
        TodoItem(
            id = "25",
            text = "Очень оригинальный текст 25",
            importance = Importance.Normal,
            isReady = false,
            creationDate = LocalDate.now()
        )
    )

    fun addTodoItem(todoItem: TodoItem) = todoItemsList.add(todoItem)

    fun getAllTodoItems() : List<TodoItem> = todoItemsList.toList()
}