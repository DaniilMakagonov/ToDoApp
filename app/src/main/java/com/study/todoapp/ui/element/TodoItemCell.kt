package com.study.todoapp.ui.element

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.study.todoapp.R
import com.study.todoapp.data.Importance
import com.study.todoapp.data.TodoItem
import com.study.todoapp.navigation.Screen
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun TodoItemCell(todoItem: TodoItem, navController: NavController, onCheckboxChange: () -> Unit) {
    val itemReady = remember { mutableStateOf(todoItem.isReady) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp))
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Checkbox(
            checked = itemReady.value,
            onCheckedChange = {
                itemReady.value = it
                todoItem.isReady = it
                onCheckboxChange()
            },
            colors = if (todoItem.importance == Importance.High)
                CheckboxDefaults.colors(uncheckedColor = Color.Red, checkedColor = Color.Green)
            else CheckboxDefaults.colors(checkedColor = Color.Green)
        )

        if (!todoItem.isReady && todoItem.importance != Importance.Normal) {
            Image(
                painter = painterResource(id = todoItem.importance.imageID),
                contentDescription = null,
                modifier = Modifier.padding(end = 10.dp)
            )
        }

        Column {
            Text(
                text = todoItem.text,
                textDecoration = if (!itemReady.value) TextDecoration.None else TextDecoration.LineThrough,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .fillMaxWidth(.85f)

            )

            if (!itemReady.value && todoItem.deadline != null) {
                Text(
                    text = "Сделать до: ${
                        todoItem.deadline!!
                            .format(DateTimeFormatter.ofPattern(stringResource(id = R.string.date_format)))
                    }",
                    color = Color.Gray,
                    modifier = Modifier.padding(bottom = 3.dp)
                )
            }
        }

        IconButton(
            onClick = {
                navController.navigate(Screen.NewItem.withArgs(todoItem.id))
            },
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.info),
                contentDescription = null
            )
        }
    }
}


@Preview
@Composable
fun TodoItemCellPreview() {
//    with default theme
    val todoItem = TodoItem(
        id = "0",
        text = "Очень важное дело, необходимость которого очень трудно переоценить. " +
                "Именно поэтому каждое слово, написанное здесь, невероятно ценно. " +
                "Спасибо, что мне хватило фантазии на это все.",
        importance = Importance.High,
        isReady = true,
        creationDate = LocalDate.now(),
        deadline = LocalDate.now().plusDays(7L)
    )
    TodoItemCell(
        todoItem = todoItem,
        navController = rememberNavController(),
        onCheckboxChange = {})

//    with custom theme
//    ToDoAppTheme{
//        val todoItem = TodoItem(
//            id = "0",
//            text = "Очень важное дело, необходимость которого очень трудно переоценить. " +
//                    "Именно поэтому каждое слово, написанное здесь, невероятно ценно. " +
//                    "Спасибо, что мне хватило фантазии на это все.",
//            importance = Importance.Low,
//            isReady = true,
//            creationDate = LocalDate.now()
//        )
//        TodoItemCell(todoItem = todoItem)
//    }
}