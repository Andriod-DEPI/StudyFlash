package com.example.studyflash.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.studyflash.R
import com.example.studyflash.ui.theme.GradientColor
import com.example.studyflash.ui.theme.SignikaFamily
import com.example.studyflash.ui.theme.StudyFlashTheme
import com.example.studyflash.ui.theme.TopBarBg
import com.example.studyflash.ui.theme.Wording
import com.example.studyflash.ui.theme.WordingBtn
import com.example.studyflash.ui.theme.YrsaFamily
import androidx.navigation.NavHostController

@Composable
fun TopLayer() {

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(116.dp)
        .clip(
            RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 16.dp,
                bottomEnd = 16.dp
            )
        )
        .background(TopBarBg),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Text(
          text = "StudyFlash",
            modifier = Modifier.offset(y = (-12).dp),
            style = TextStyle(
                fontSize = 37.sp,
                fontFamily = YrsaFamily,
                fontWeight = FontWeight.Bold,
                color = Wording,
            )
        )
    }
}

@Composable
fun LandPage(navController: NavHostController) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Wording)
    ) {
        TopLayer()
        Text(
            text = "StudyFlash",
            modifier = Modifier
                .padding(start = 16.dp, top = 25.dp),
            style = TextStyle(
                fontSize = 28.sp,
                fontFamily = SignikaFamily,
                fontWeight = FontWeight.Bold,
                color = TopBarBg,
            )
        )
        Text(
            text = "       is your way to create, organize, categorize and manage Flash Cards and use them for efficient studying.",
            modifier = Modifier
                .padding(start = 16.dp, top = 25.dp, end = 16.dp),
            style = TextStyle(
                fontSize = 28.sp,
                fontFamily = SignikaFamily,
                color = TopBarBg,
            )
        )
        Image(
            painter = painterResource(id = R.drawable.land_page),
            contentDescription = "LandPage_image",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            contentScale = ContentScale.Crop
        )
        Button(
            onClick = {
                // got to signup page
                navController.navigate("SignIn")
            },
            modifier = Modifier
                .padding(start = 100.dp, top = 50.dp)
                .background(
                    brush = GradientColor,
                    shape = RoundedCornerShape(50)
                )
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(50),
                    clip = false
                ),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Text(
                text = "Create Account",
                fontSize = 20.sp,
                color = WordingBtn,
                )
        }

        Button(
            onClick = {
                // got to login page
                navController.navigate("logIn")
            },
            modifier = Modifier
                .padding(start = 100.dp, top = 20.dp)
                .width(190.dp)
                .background(
                    brush = GradientColor,
                    shape = RoundedCornerShape(50)
                )
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(50),
                    clip = false
                ),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
        ) {
            Text(
                text = "Sign in",
                fontSize = 20.sp,
                color = WordingBtn,
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewLandPage() {
    StudyFlashTheme {
        LandPage(navController = rememberNavController())
    }
}

