package com.example.studyflash.ui.colors

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.studyflash.ui.theme.Blue
import com.example.studyflash.ui.theme.BlueStroke
import com.example.studyflash.ui.theme.Brown
import com.example.studyflash.ui.theme.BrownStroke
import com.example.studyflash.ui.theme.Green
import com.example.studyflash.ui.theme.GreenStroke
import com.example.studyflash.ui.theme.Pink
import com.example.studyflash.ui.theme.PinkStroke
import com.example.studyflash.ui.theme.Purple
import com.example.studyflash.ui.theme.PurpleStroke
import com.example.studyflash.ui.theme.Yellow
import com.example.studyflash.ui.theme.YellowStroke

val textfield = Color(0xFFD0DDFC)

val ColorScheme.focusedTextFieldText

    @Composable
    get() = if (isSystemInDarkTheme()) textfield else textfield

val ColorScheme.unfocusedTextFieldText

    @Composable
    get() = if (isSystemInDarkTheme())  textfield else textfield

val ColorScheme.textFieldContainer

    @Composable
    get() = if (isSystemInDarkTheme())  textfield else textfield


enum class Colors (val id:Int, val color: Color, val strokeColor: Color){
    GreenColor(1, Green, GreenStroke),
    YellowColor(2,Yellow, YellowStroke),
    BlueColor(3, Blue, BlueStroke),
    PinkColor(4, Pink, PinkStroke),
    PurpleColor(5, Purple, PurpleStroke),
    BrownColor(6, Brown, BrownStroke);
    companion object {
        fun getColorById(id:Int):Colors{
            return entries.find { it.id == id }!!
        }
    }
}