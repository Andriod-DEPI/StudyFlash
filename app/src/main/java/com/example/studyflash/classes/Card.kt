package com.example.studyflash.classes

data class Card(
    val id: Int,
    val title: String,
    val content: String,
    val colorID: Int,
    var isChecked: Boolean
)
