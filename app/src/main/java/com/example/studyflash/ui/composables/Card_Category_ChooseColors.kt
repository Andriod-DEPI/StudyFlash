package com.example.studyflash.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.studyflash.ui.theme.Green
import com.example.studyflash.ui.theme.PrimaryColor

@Composable
fun ChooseColor(color:Color, index: Int, isSelected:Boolean, onClick:()->Unit){
    Box(modifier = Modifier.clip(RoundedCornerShape(5.dp)).size(50.dp).background(color).border(
        if(isSelected) 1.5.dp else 0.dp,
        if (isSelected) PrimaryColor else Color.Transparent,
        if (isSelected) RoundedCornerShape(5.dp) else RoundedCornerShape(0.dp)
    ).clickable { onClick() }
    ) {
    }
}