package com.study.todoapp.ui.element

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun NewItemButton() {
    FloatingActionButton(onClick = { /*TODO*/ }) {
       Icon(Icons.Filled.Add, null)
    }
}