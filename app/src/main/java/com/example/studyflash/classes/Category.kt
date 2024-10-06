package com.example.studyflash.classes

import androidx.compose.ui.graphics.Color

data class Category(val id:Int, val name:String, val color: Color, val colorStroke: Color, val cards:List<Card>)
