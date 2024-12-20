package com.example.studyflash.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.studyflash.R


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val YrsaFamily = FontFamily(
    Font(R.font.yrsa_bold, FontWeight.Bold),
    Font(R.font.yrsa_regular, FontWeight.Normal)
)

val SignikaFamily = FontFamily(
    Font(R.font.signika_bold, FontWeight.Bold),
    Font(R.font.signika_regular, FontWeight.Normal)
)

val ReadexProFamily = FontFamily(
    Font(R.font.readexpro_medium, FontWeight.Medium)
)
val RedRoseFamily = FontFamily(
    Font(R.font.redrose_bold, FontWeight.Bold)
)
val RedHatFamily = FontFamily(
    Font(R.font.redhattext_semibold, FontWeight.SemiBold)
)

val AlexandriaFamily = FontFamily(
    Font(R.font.alexandria_regular, FontWeight.Normal),
    Font(R.font.alexandria_bold, FontWeight.Bold),
    Font(R.font.alexandria_semi_bold, FontWeight.SemiBold)
)

    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */