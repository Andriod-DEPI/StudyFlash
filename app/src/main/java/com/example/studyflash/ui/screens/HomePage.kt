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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.studyflash.classes.Category
import com.example.studyflash.ui.colors.Colors
import com.example.studyflash.ui.components.TopBar
import com.example.studyflash.ui.theme.ReadexProFamily
import com.example.studyflash.ui.theme.RedRoseFamily
import com.example.studyflash.ui.theme.StudyFlashTheme
import com.example.studyflash.ui.theme.TopBarBg
import com.example.studyflash.ui.theme.Wording
import com.example.studyflash.viewmodels.CategoryCardViewModel

//data class Subject(val name: String, val progress: Float)       // will be updated


@Composable
fun HomePage(navController: NavHostController) {

    val viewModel: CategoryCardViewModel = hiltViewModel()
    // Collect the category list from the ViewModel
    val categoryList by viewModel.Categories.collectAsState()

    // Load the categories when the composable is first composed
    LaunchedEffect(Unit) {
        viewModel.loadCategories()
    }


    Column(modifier = Modifier
        .fillMaxSize()
        .background(Wording)
    ) {

        TopBar(navController)
        
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

//        val categoryList = listOf(
//            Category(
//                id = 1,
//                name = "Math",
//                colorID = 1, // Example color (Red 300)
//                cards = listOf(),
//                progress = 50
//            ),
//            Category(
//                id = 2,
//                name = "Science",
//                colorID = 2, // Example color (Green 300)
//                cards = listOf(),
//                progress = 70
//            ),
//            Category(
//                id = 3,
//                name = "History",
//                colorID = 3, // Example color (Blue 300)
//                cards = listOf(),
//                progress = 30
//            )
//        )

        val categoryNameColorPairs: List<Pair<String, Int>> = categoryList.map { category ->
            category.name to category.colorID
        }
        CardsRow(
            categoryNameColorPairs,
            navController
        )

        SubjectProgressList(subjects = categoryList)
    }
}

@Composable
fun CardsRow(items: List<Pair<String,Int>>, navController: NavHostController) {
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
        items.take(3).forEachIndexed{index,item ->
            CardItem(
                index,
                backgroundColor = Colors.getColorById(item.second).color,
                backgroundTextColor = Colors.getColorById(item.second).strokeColor,
                text = item.first,
                navController= navController)}
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
    ID:Int,
    backgroundColor: Color,
    backgroundTextColor: Color,
    text: String,
    navController: NavHostController
) {
    Card(
        modifier = Modifier
            .size(100.dp, 150.dp)
            .padding(8.dp)
//            .clickable { navController.navigate("Cards List/${ID}") },
        ,shape = RoundedCornerShape(20),
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

@Composable
fun SubjectProgressList(subjects: List<Category>) {

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
            limitedSubjects.take(3).forEach{subject ->
                CircularSubjectIndicator(
                    progress = subject.progress.toFloat(),
                    color = Colors.getColorById(subject.colorID).strokeColor,
                    subject = subject.name
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            limitedSubjects.drop(3).forEach{subject ->
                CircularSubjectIndicator(
                    progress = subject.progress.toFloat(),
                    color = Colors.getColorById(subject.colorID).strokeColor,
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
                    progress/100   // assuming his total score is 100
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
