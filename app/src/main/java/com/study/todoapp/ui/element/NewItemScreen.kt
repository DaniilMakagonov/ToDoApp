package com.study.todoapp.ui.element

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.study.todoapp.R
import com.study.todoapp.data.Importance
import com.study.todoapp.data.TodoItem
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewItemScreen(item: TodoItem? = null) {
    var id: String
    var text by remember { mutableStateOf(item?.text ?: "") }
    var importance = item?.importance ?: Importance.Normal
    var isReady = item?.isReady ?: false
    var creationDate = item?.creationDate ?: LocalDate.now()
    var deadline = item?.deadline
    var lastChangeDate = LocalDate.now()

    Scaffold(
        containerColor = Color(0xFFF7F6F2),
        topBar = {
            TopAppBar(
                title = {},
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFFF7F6F2)),
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Filled.Close, contentDescription = null)
                    }
                },
                actions = {
                    Text(
                        text = "СОХРАНИТЬ",
                        color = Color.Blue,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .padding(end = 20.dp)
                            .clickable {
                                if (item != null) {
                                    item.text = text
                                    item.importance = importance
                                    item.deadline = deadline
                                }
                            /*TODO*/
                            }
                    )
                }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            item {
                InputField(text = text) { inputValue -> text = inputValue }
            }
            item {
                ImportanceChoose(importance.name) { newImportance ->
                    importance = newImportance
                }
            }
            item {
                Divider()
            }
            item {
                DateChoose(deadline)
            }
            item {
                Divider()
            }
            item {
                DeleteIcon(item != null)
            }
        }
    }
}

@Composable
fun InputField(text: String, onValueChanged: (String) -> Unit) {
    OutlinedTextField(
        value = text,
        onValueChange = onValueChanged,
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            focusedBorderColor = Color.White,
            unfocusedBorderColor = Color.White
        ),
        placeholder = {
            Text(
                text = "Нужно сделать...",
                color = Color.Gray
            )
        },
        modifier = Modifier
            .fillMaxWidth()
    )
}

@Composable
fun ImportanceChoose(importance: String, onImportanceChange: (Importance) -> Unit) {
    var expanded by remember {
        mutableStateOf(false)
    }
    var currentImportance by remember { mutableStateOf(importance) }

    Column(
        modifier = Modifier
            .clickable { expanded = true }
    ) {
        Text(
            text = "Важность",
            fontSize = 20.sp
        )
        Text(text = currentImportance)
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            DropdownMenuItem(
                text = { Text(text = Importance.Low.name) },
                onClick = {
                    onImportanceChange(Importance.Low)
                    expanded = false
                    currentImportance = Importance.Low.name
                }
            )
            DropdownMenuItem(
                text = { Text(text = Importance.Normal.name) },
                onClick = {
                    onImportanceChange(Importance.Low)
                    expanded = false
                    currentImportance = Importance.Normal.name
                }
            )
            DropdownMenuItem(
                text = {
                    Text(
                        text = "!!${Importance.High.name}", color = Color.Red
                    )
                },
                onClick = {
                    onImportanceChange(Importance.Low)
                    expanded = false
                    currentImportance = Importance.High.name
                }
            )

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateChoose(deadline: LocalDate?) {
    var isDateSet by remember {
        mutableStateOf(deadline != null)
    }
    var isDialogOpen by remember {
        mutableStateOf(false)
    }
    var pickedDate by remember {
        mutableStateOf(deadline ?: LocalDate.now())
    }

    val datePickerState = rememberDatePickerState(pickedDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli())

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Text(
                text = "Сделать до",
                fontSize = 20.sp,
            )
            if (isDateSet) {
                Text(text = pickedDate.format(DateTimeFormatter.ofPattern(stringResource(id = R.string.date_format))))
            }
        }
        Switch(
            checked = isDateSet,
            onCheckedChange = {
                if (!isDateSet)
                    isDialogOpen = true
                else
                    isDateSet = false
            }
        )
    }

    if (isDialogOpen) {
        DatePickerDialog(
            onDismissRequest = {},
            confirmButton = {
                TextButton(
                    enabled = datePickerState.selectedDateMillis != null,
                    onClick = {
                        isDialogOpen = false
                        isDateSet = true
                        pickedDate = toLocalDateFromEpochMillis(datePickerState.selectedDateMillis!!)
                    }
                ) {
                    Text(text = "Сохранить")
                }
            },
            dismissButton = {
                TextButton(onClick = {
                    isDialogOpen = false
                    isDateSet = false
                }) {
                    Text(text = "Отмена")
                }
            }
        ) {
            DatePicker(
                state = datePickerState,
                dateValidator = {
                    toLocalDateFromEpochMillis(it) >= LocalDate.now()
                }
            )
        }
    }

}

@Composable
fun DeleteIcon(enabled: Boolean) {
    Row(modifier = Modifier.clickable(enabled = enabled) { /*TODO*/ }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = null,
            tint = if (enabled) Color.Red else Color.Gray
        )
        Text(
            text = "Удалить",
            fontSize = 20.sp,
            color = if (enabled) Color.Red else Color.Gray,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}

@Composable
@Preview
fun NewItemScreenResource() {
    NewItemScreen()
}

fun toLocalDateFromEpochMillis(millis: Long) : LocalDate {
    return Instant.ofEpochMilli(millis).atZone(ZoneId.systemDefault()).toLocalDate()
}