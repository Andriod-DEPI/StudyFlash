package com.example.studyflash.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun topRectangle(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(300.dp)
        .background(Color(0XFF6A31F7))
    )
}

@Preview
@Composable
fun QuizScreen() {
    Box (
        modifier= Modifier
            .fillMaxSize()
            .background(Color(0xFFEDF5FF))
    ){
        topRectangle()
        Card (
            modifier = Modifier
                .width(325.dp)
                .height(650.dp)
//                .offset(y = -0.dp)
                .align(Alignment.Center)
//                .padding(10.dp)
                .graphicsLayer {
                    // Adjust shadow properties
                    shadowElevation =
                        8.dp.toPx() // Set shadow elevation (change this value for depth)
                    shape = RoundedCornerShape(20.dp) // Set shadow shape
                    clip = true // Clip the shadow to the shape
                }
                .alpha(0.9f),
//                .background(Color(0xFFEDF5FF)),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFEDF5FF)
            ),

        ){
            Column (
                modifier = Modifier
                    .padding(15.dp)
            ){
                Quiz()
            }
        }
    }
}