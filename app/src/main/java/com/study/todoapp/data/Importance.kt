package com.study.todoapp.data

import com.study.todoapp.R

sealed class Importance(val name: String, val imageID: Int) {
    data object Low : Importance("Низкая", R.drawable.low_importance)
    data object Normal : Importance("Средняя", -1)
    data object High : Importance("Высокая", R.drawable.high_importance)

}