package com.example.studyflash.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

//////////////////////////////

val TopBarBg = Color(0xFF6A31F7)
val Wording = Color(0xFFEDF5FF)
val WordingBtn = Color(0xFFF8EDE3)
val GradientColor = Brush.linearGradient(
    colors = listOf( Color(0xFFD987F5),Color(0xFF7E9EF7))
)

// cards colors

val LightGreen = Color(0xFFA8D5B2)
val LightOrange = Color(0xFFF9DEBE)
val LightBlue = Color(0xFFC4DCEE)

val LightGreenText = Color(0xFF5B8263)
val LightOrangeText = Color(0xFF95826B)
val LightBlueText = Color(0xFF687D8D)


// progress bars

val GreenCircle = Color(0xFF5B8263)
val BlueCircle = Color(0xFF427499)
val PurpleCircle = Color(0xFFB284B9)
val GoldenCircle = Color(0xFFE8AE67)
val RoseCircle = Color(0xFFC18187)



val PrimaryColor = Color(0xFF6A31F7)
val BackgroundColor = Color(0xFFEDF5FF)

// pastel colors
val Green = Color(0xFFA8D5B2)
val GreenStroke = Color(0xFF5B8263)

val Yellow = Color(0xFFF9DEBE)
val YellowStroke = Color(0xFFBEA68A)

val Blue = Color(0xFFC4DCEE)
val BlueStroke = Color(0xFF88A0B3)

val Pink = Color(0xFFF7C9CD)
val PinkStroke = Color(0xFFA57B7E)

val Purple = Color(0xFFECD1F1)
val PurpleStroke = Color(0xFFB28CB8)

val Brown = Color (0xFFDCC1A2)
val BrownStroke = Color(0xFF8A7153)

    //add_edit
val add_edit_border = Color(0xFF8773B9)
val add_edit_bck = Color(0xD5F4F4F4)
val add_edit_txtField_bck = Color(0xFFE7DDFF)

//Text field
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



