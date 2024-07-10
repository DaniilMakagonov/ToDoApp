package com.study.todoapp.ui.element

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import com.study.todoapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    scrollBehavior: TopAppBarScrollBehavior,
    doneAmount: Int,
    isVisible: Boolean,
    onChangeVisibility: () -> Unit
) {
    LargeTopAppBar(
        title = {
            if (scrollBehavior.state.collapsedFraction < .7) {
                Column {
                    Text(text = "Мои дела")

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Выполнено - $doneAmount")
                        IconButton(onClick = onChangeVisibility) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = if (isVisible) R.drawable.visible else R.drawable.invisible),
                                contentDescription = null
                            )
                        }
                    }
                }
            } else {
                Column {
                    Text(text = "Мои дела")
                }
            }
        },
        actions = {
            if (scrollBehavior.state.collapsedFraction > .7) {
                IconButton(onClick = onChangeVisibility) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = if (isVisible) R.drawable.visible else R.drawable.invisible),
                        contentDescription = null
                    )
                }
            }
        },
        scrollBehavior = scrollBehavior
    )
}