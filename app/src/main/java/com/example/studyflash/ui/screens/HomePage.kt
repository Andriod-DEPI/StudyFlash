package com.example.studyflash.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.studyflash.ui.components.TopBar
import com.example.studyflash.ui.theme.*


@Composable
fun HomePage(navController: NavHostController) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Wording)
    ) {

        TopBar()
        
        Text(
            text = "Welcome back, Sandy!",
            modifier = Modifier
                .padding(start = 16.dp, top = 35.dp),
            style = TextStyle(
                fontSize = 28.sp,
                fontFamily = ReadexProFamily,
                fontWeight = FontWeight.Medium,
                color = TopBarBg,
            )
        )

        Spacer(modifier = Modifier.height(60.dp))

        val items = listOf("Technology", "Science", "Mathematics", "Engineering")
        CardsRow(
            items,
            onCardClick = { clickedItem ->
                println("Clicked on: $clickedItem")
            },
            navController
        )

        val subjects = listOf(
            Subject("Technology", 0.75f),
            Subject("Mathematics", 0.60f),
            Subject("Chemistry", 0.40f),
            Subject("Science", 0.50f),
            Subject("English", 0.30f),
            Subject("History", 0.20f)
        )
        SubjectProgressList(subjects = subjects)
    }
}

@Composable
fun CardsRow(items: List<String>, onCardClick: (String) -> Unit, navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .drawBehind {
                // Draw the top border
                drawLine(
                    color = TopBarBg,
                    start = Offset(0f, 0f),
                    end = Offset(size.width, 0f),
                    strokeWidth = 2.dp.toPx()
                )
                // Draw the bottom border
                drawLine(
                    color = TopBarBg,
                    start = Offset(0f, size.height),
                    end = Offset(size.width, size.height),
                    strokeWidth = 2.dp.toPx()
                )}
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        items.take(3).forEachIndexed { index, item ->
            CardItem(
                backgroundColor = when (index) {
                    0 -> LightGreen
                    1 -> LightOrange
                    else -> LightBlue
                },
                backgroundTextColor = when (index) {
                    0 -> LightGreenText
                    1 -> LightOrangeText
                    else -> LightBlueText
                },
                text = item,
                onClick = { onCardClick(item) } // navigate to cards list page
            )
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Next",
            tint = TopBarBg,
            modifier = Modifier
                .size(48.dp)
                .clickable { navController.navigate("categories") } // navigate to categories screen
        )
    }
}

@Composable
fun CardItem(
    backgroundColor: Color,
    backgroundTextColor: Color,
    text: String,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(100.dp, 150.dp)
            .padding(8.dp)
            .clickable { onClick() }, // NEEDS TO BE FIXED
        shape = RoundedCornerShape(20),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = text,
                fontSize = 12.sp,
                fontFamily = RedRoseFamily,
                fontWeight = FontWeight.Bold,
                color = backgroundTextColor ,
            )
        }
    }
}

data class Subject(val name: String, val progress: Float)       // will be updated

@Composable
fun SubjectProgressList(subjects: List<Subject>) {

    val limitedSubjects = subjects.take(5)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            limitedSubjects.take(3).forEachIndexed {index, subject ->
                CircularSubjectIndicator(
                    progress = subject.progress,
                    color = when (index) {
                        0 -> GreenCircle
                        1 -> BlueCircle
                        else -> PurpleCircle
                    },
                    subject = subject.name
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            limitedSubjects.drop(3).forEachIndexed {index, subject ->
                CircularSubjectIndicator(
                    progress = subject.progress,
                    color =  when (index) {
                        0 -> GoldenCircle
                        else -> RoseCircle
                    },
                    subject = subject.name
                )
            }
        }
    }
}

@Composable
fun CircularSubjectIndicator(progress: Float, color: Color, subject: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(contentAlignment = Alignment.Center) {
            // Background circle (gray)
            CircularProgressIndicator(
                progress = {
                    1f
                },
                modifier = Modifier.size(65.dp),
                color = Color.LightGray,
                strokeWidth = 8.dp,
            )
            // Foreground circle (colored)
            CircularProgressIndicator(
                progress = {
                    progress
                },
                modifier = Modifier.size(65.dp),
                color = color,
                strokeWidth = 8.dp,
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = subject,
            fontFamily = RedRoseFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 12.sp,
            color = color
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewHome() {
    StudyFlashTheme {
        HomePage(navController= rememberNavController())
    }
}
