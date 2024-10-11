package com.example.studyflash.viewmodels

data class Category(
    val name: String,
    val numberOfCards: Int,
    val numberOfCompleted: Int,
    val id: Int
)

//val items = listOf(
//    Category("Math", numberOfCards = 10, numberOfCompleted = 5),
//    Category("Science", numberOfCards = 15, numberOfCompleted = 8),
//    Category("History", numberOfCards = 20, numberOfCompleted = 12),
//    Category("Art", numberOfCards = 5, numberOfCompleted = 2)
//)
