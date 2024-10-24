package com.example.studyflash.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyflash.R
import com.example.studyflash.ui.components.Score

@Composable
fun MyIcon(score: Int){
    val icon = when{
        score == 100 -> R.drawable.happiness
        score > 50  -> R.drawable.smile
        score > 25  -> R.drawable.neutral
        else -> R.drawable.sad
    }
    Image(
        painter = painterResource(id = icon),
        contentDescription = "Score icon",
        colorFilter = ColorFilter.tint(Color.Black),
        modifier = Modifier
            .size(60.dp)
            .alpha(1f)
    )
}

@Composable
fun QuizScore(){
    Box (
        modifier= Modifier
            .fillMaxSize()
            .background(Color(0xFFEDF5FF))
    ){
        topRectangle()
        Card (
            modifier = Modifier
                .width(325.dp)
                .height(300.dp)
                .offset(y = -80.dp)
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
                    .fillMaxWidth()
            ){
                Row (
                    modifier = Modifier
                        .fillMaxWidth() //important for alignment
                        .padding(top = 20.dp)
                        .weight(2f),
                    horizontalArrangement = Arrangement.Center
                ){
                    MyIcon(score = 50)
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth() //important for alignment
                        .padding(top = 10.dp)
                        .weight(1f),
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(text = "You answered 3/5",
                        modifier = Modifier
                            .padding(bottom = 10.dp),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth() //important for alignment
                        .padding(top = 10.dp)
                        .weight(1f),
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(text = "Your Total Score Is:",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold)
                }
                Row (
                    modifier = Modifier
                        .fillMaxWidth() //important for alignment
                        .padding(bottom = 0.dp)
                        .weight(1.5f),
                    horizontalArrangement = Arrangement.Center
                ){
                Score()
                }
            }
        }
    }
}

@Preview
@Composable
fun QuizScorePreview(){
    QuizScore()
}