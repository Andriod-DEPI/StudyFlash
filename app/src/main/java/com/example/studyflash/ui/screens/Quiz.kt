package com.example.studyflash.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyflash.R

@Preview(showBackground = true)
@Composable
fun Quiz (){
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.categories),
                    contentDescription = "categories",
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = "Technology",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 5.dp)
                )
            }
            Spacer(modifier = Modifier.weight(2f))
            Row {
                Text(
                    text = "20:00",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 5.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.hourglass1),
                    contentDescription = "categories",
                    modifier = Modifier.size(20.dp)
                )
            }
        }
        Row (
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ){
            Text(text = "Quiz",
                fontSize = 36.sp
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            Column {
                Row (
                    modifier = Modifier
                        .background(
                            color = Color(0xFFFF873D), // Orange color
                            shape = RoundedCornerShape(20.dp) // Rounded corners
                        )
                        .padding(horizontal = 4.dp, vertical = 1.dp)
                ){
                    Column(
                        modifier = Modifier.align(Alignment.CenterVertically)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.bulb),   // Use Icon directly
                            contentDescription = "Energy Icon",
                            tint = Color(0xFFFFF1D6),
                            modifier = Modifier
                                .size(25.dp)
                                .padding(start = 0.dp)
                        )
                    }
                    Column(
                        modifier = Modifier.align(Alignment.CenterVertically)

                    ) {
                        Text(
                            text = "30",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            letterSpacing = 1.sp,
                            color = Color(0xFFFFF1D6),
//                modifier = Modifier.weight(1f)
                            modifier = Modifier.padding(start = 5.dp, end = 5.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(2f))
//            Column {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = "1/5",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 5.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.checkmark1),
                        contentDescription = "categories",
                        tint = Color(0xFF4CD961),
                        modifier = Modifier
                            .size(25.dp)
                            .padding(3.dp)
                    )
                }
//            }
        }
        Row (){
            Card (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 15.dp)
                    .border(BorderStroke(1.dp, Color(0xFFCCCCCC)), RoundedCornerShape(20.dp))
                    .background(Color(0xFFEDF5FF), shape = RoundedCornerShape(20.dp))
                    .graphicsLayer {
                        // Adjust shadow properties
//                        shadowElevation = 4.dp.toPx()
                        shape = RoundedCornerShape(20.dp) // Set shadow shape
                        clip = true // Clip the shadow to the shape
                    },
//                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
            ){
                Text(text = "Wifi Stands for _________",
                    modifier = Modifier
                        .padding(15.dp))
            }
        }
        Row {
            Spacer(modifier = Modifier.weight(2f))
//            Button(){
//                Text(text = "Check")
//            }
        }
        Row {

        }
        Row {

        }
    }
}