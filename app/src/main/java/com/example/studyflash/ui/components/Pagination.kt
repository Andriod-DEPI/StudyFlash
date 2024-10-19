package com.example.studyflash.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

fun incCurrentIndex(){
    println("incrementing index")
}
fun decCurrentIndex(){
    println("decrementing index")
}

@Composable
fun PaginationDots(
    totalDots: Int,
    currentIndex: Int,
    modifier: Modifier = Modifier,
){
    Row (
        verticalAlignment = Alignment.CenterVertically,
    ){
        Column {
            IconButton(onClick = { decCurrentIndex() },
                modifier = Modifier
//                    .background(Color.Transparent)
                    .padding(10.dp)
                    .size(20.dp),
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowBackIos, contentDescription = "Back",
                    modifier = Modifier
                        .size(30.dp)
//                        .background(Color.Transparent)
                    )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center
//            modifier = modifier.fillMaxWidth()
        ) {
            for (i in 0 until totalDots) {
                val isCurrent = i == currentIndex
                //order of modifiers is important
                Box(
                    modifier = Modifier
                        .padding(horizontal = 3.dp)
                        .size(10.dp)
                        .clip(CircleShape)
                        .background(if (isCurrent) Color(0xFFFF873D) else Color(0xFFD9D9D9))
                )
            }
        }
        Column {
            IconButton(onClick = { incCurrentIndex() },
                modifier = Modifier
                    .padding(10.dp)
                    .background(Color.Transparent)
                    .size(30.dp),
            ) {
                Icon(Icons.AutoMirrored.Filled.ArrowForwardIos, contentDescription = "Next",
                    modifier = Modifier
                        .size(20.dp)
                )
            }
        }
    }
}

@Composable
fun Pagination(){
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var totalQuestions = 10

}

@Preview
@Composable
fun PaginationDotsPreview(){
    PaginationDots(totalDots = 15, currentIndex = 10)
}

@Composable
fun QuizCard(){
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 25.dp)
//                    .border(BorderStroke(1.dp, Color(0xFFCCCCCC)), RoundedCornerShape(20.dp))
//                    .background(Color(0xFFEDF5FF), shape = RoundedCornerShape(20.dp))
            .graphicsLayer {
                // Adjust shadow properties
                shadowElevation = 4.dp.toPx()
                shape = RoundedCornerShape(20.dp) // Set shadow shape
                clip = true // Clip the shadow to the shape
            },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFEDF5FF)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ){
        Text(text = "Wifi Stands for _________",
            modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 20.dp)
        )
    }
}