package com.example.studyflash.classes

import androidx.compose.ui.graphics.Color

data class Card(val id:Int, val title:String, val content:String, val color: Color, val cardStroke: Color, var isChecked:Boolean)
