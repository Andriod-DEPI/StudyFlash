package com.example.studyflash.classes

data class Category(
    val id: Int,
    val name: String,
    val colorID: Int,
    val cards: List<Card>,
    val progress: Int
)
