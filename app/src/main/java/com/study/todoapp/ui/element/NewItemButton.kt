package com.study.todoapp.ui.element

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun NewItemButton() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        modifier = Modifier.clip(CircleShape)
    ) {
       Icon(
           imageVector = Icons.Filled.Add,
           contentDescription = null
           )
    }
}