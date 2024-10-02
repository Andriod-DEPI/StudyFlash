package com.example.studyflash.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.w3c.dom.Text


@Composable
fun TopNavBar(
    title: "StudyFlash"
){
    TopAppBar(
        title = {
            Text(text = "StudyFlash")
        },
    )
}

