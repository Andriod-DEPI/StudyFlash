package com.example.studyflash.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.studyflash.R


//@Preview(showBackground = true)
@Composable
fun TopBar (navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(116.dp)
            .background(
                Color(0xFF6A31F7),
                RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
            ),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
//        modifier = Modifier.fillMaxWidth(),
//        horizontalArrangement = Arrangement.spacedBy(16.dp) // Distribute columns evenly
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            //study flash
            Column (){
                Text(
                    text = "StudyFlash",
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    letterSpacing = 1.sp,
                    color = Color(0xFFFFFFFF),
//                modifier = Modifier.weight(1f)
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
            Score()
        }
        Row (
//            modifier = Modifier // Align TopNavBar to the end (right)
//                .padding(end = 16.dp)
        ) {
            TopNavBar(navController = navController)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun TopBarPreview(){
    TopBar(navController = rememberNavController())
}

@Composable
fun Score(){
    Column (
        modifier = Modifier.padding(start = 20.dp, top = 10.dp)
    ){
        Row (
            modifier = Modifier
                .background(
                    color = Color(0xFFFF873D), // Orange color
                    shape = RoundedCornerShape(20.dp) // Rounded corners
                )
                .padding(horizontal = 8.dp, vertical = 4.dp)
        ){
            Column(
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.energy),   // Use Icon directly
                    contentDescription = "Energy Icon",
                    tint = Color(0xFFFFF1D6),
                    modifier = Modifier
                        .size(25.dp)
                        .padding(start = 2.dp)
                )
            }
            Column(
                modifier = Modifier.align(Alignment.CenterVertically)

            ) {
                Text(
                    text = "30",
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    letterSpacing = 1.sp,
                    color = Color(0xFFFFF1D6),
//                modifier = Modifier.weight(1f)
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                )
            }
        }
    }
}