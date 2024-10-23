package com.example.studyflash.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.studyflash.viewmodels.Questions
import com.example.studyflash.viewmodels.Quiz
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

fun incCurrentIndex(index: Int, totalDots: Int): Int{
    println("incrementing index")
    if(index<totalDots-1)
        return index + 1
    else
        return index
}
fun decCurrentIndex(index: Int): Int{
    println("decrementing index")
    if(index>0)
        return index - 1
    else
        return index
}

@Composable
fun PaginationDots(
    totalDots: Int,
    currentIndex: Int,
    onIndexChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
){
//    var currentQuestionIndex by remember { mutableStateOf(0) }
//    var totalQuestions = 10
    Row (
        verticalAlignment = Alignment.CenterVertically,
//        horizontalArrangement = Arrangement.Center,
    ){
        Column {
            IconButton(onClick = { onIndexChange(decCurrentIndex(currentIndex)) },
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
            IconButton(onClick = { onIndexChange(incCurrentIndex(currentIndex, totalDots)) },
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
fun QuizCard(quiz: Quiz) {
    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 30.dp)
            .graphicsLayer {
                // Adjust shadow properties
                shadowElevation = 4.dp.toPx()
                shape = RoundedCornerShape(20.dp) // Set shadow shape
                clip = true // Clip the shadow to the shape
            },
        colors = CardDefaults.cardColors(
            containerColor = if (!quiz.isCorrect && quiz.IsDone) Color(0xFFFFCDD2) else Color(0xFFEDF5FF)  // Red if wrong, else default color
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ){
        Text(text = quiz.Question,
            modifier = Modifier
                .padding(vertical = 20.dp, horizontal = 20.dp)
        )
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun QuizPage (
    quizList: List<Quiz>,
    currentIndex: Int,
    onIndexChange: (Int) -> Unit,
    modifier: Modifier,
    isWrong: Boolean = false,
//    onSubmitQuiz: () -> Unit
){
    val pagerState = rememberPagerState() // Pager state to track the current page
    val coroutineScope = rememberCoroutineScope()

    // Handle changes in page swipe
    LaunchedEffect(pagerState.currentPage) {
        onIndexChange(pagerState.currentPage)
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // QuizPager Composable to show questions
        if (currentIndex < quizList.size) {
            HorizontalPager(
                count = quizList.size,
                state = pagerState,
                modifier = Modifier
//                .weight(1f) // Make it fill the available vertical space
                    .heightIn(max = 400.dp)
            ) { page ->
                QuizCard(quiz = quizList[page])
            }
        }
//        else {
//            // Show the Submit button when it's the last question
//            Button(
//                onClick = { onSubmitQuiz() },
//                modifier = Modifier.padding(16.dp)
//            ) {
//                Text(text = "Submit Quiz")
//            }
//        }




        LaunchedEffect(currentIndex) {
            coroutineScope.launch {
                pagerState.animateScrollToPage(currentIndex)
            }
        }
    }
}

@Preview
@Composable
fun QuizPagePreview() {
    Column {
//        QuizCard(quizList[page])
        QuizPage(quizList = Questions, currentIndex = 5, onIndexChange = {}, modifier = Modifier)
    }
}

//@Composable
//fun QuizCard(){
//    Card (
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(top = 20.dp, bottom = 30.dp)
//            .graphicsLayer {
//                // Adjust shadow properties
//                shadowElevation = 4.dp.toPx()
//                shape = RoundedCornerShape(20.dp) // Set shadow shape
//                clip = true // Clip the shadow to the shape
//            },
//        colors = CardDefaults.cardColors(
//            containerColor = Color(0xFFEDF5FF)
//        ),
//        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
//    ){
//        Text(text = "Wifi Stands for _________",
//            modifier = Modifier
//                .padding(vertical = 20.dp, horizontal = 20.dp)
//        )
//    }
//}

//@Composable
//fun Pagination(){
//    var currentQuestionIndex by remember { mutableStateOf(0) }
//    var totalQuestions = 10
//    Column {
//
//    }
//}
//@Preview
//@Composable
//fun PaginationDotsPreview(){
//    Column{
////        QuizCard(quizList[page])
//        QuizPage(quizList = Questions, currentIndex = 5, onIndexChange = {}, modifier = Modifier, onSubmitQuiz = { () -> Unit } )
//        PaginationDots(totalDots = 15, currentIndex = 10, onIndexChange = {})
//    }
//}
