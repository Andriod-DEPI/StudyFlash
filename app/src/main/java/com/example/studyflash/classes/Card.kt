package com.example.studyflash.classes

data class Card(
    val id: Int,
    val categoryID: Int,
    val title: String,
    val content: String,
    var colorID: Int,
    var isChecked: Boolean
) { constructor() : this(0, 1,"","", 0,false)
}
