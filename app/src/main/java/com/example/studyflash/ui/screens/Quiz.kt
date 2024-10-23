package com.example.studyflash.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.studyflash.R
import com.example.studyflash.ui.components.HintButton
import com.example.studyflash.ui.components.HintList
import com.example.studyflash.ui.components.PaginationDots
import com.example.studyflash.ui.components.QuizPage
import com.example.studyflash.viewmodels.Questions


fun Check(currentIndex: Int, userAns: String): Pair<Boolean, Boolean> {
    var ans = Questions[currentIndex].Answer.toLowerCase()
    var isCorrect: Boolean = false
    if(userAns.toLowerCase() == ans && !Questions[currentIndex].IsDone){
        Questions[currentIndex].IsDone = true
        Questions[currentIndex].isCorrect = true
        return Pair(true, false)
    }
    else if(userAns.toLowerCase() == ans && Questions[currentIndex].isCorrect){
        Questions[currentIndex].IsDone = true
        Questions[currentIndex].isCorrect = true
        return Pair(true, true)
    }
    else if(userAns.toLowerCase() != ans){
        Questions[currentIndex].IsDone = true
        Questions[currentIndex].isCorrect = false
        return Pair(false, false)
    }
    else if(userAns.toLowerCase() == ans && !Questions[currentIndex].isCorrect){
        Questions[currentIndex].IsDone = true
        Questions[currentIndex].isCorrect = true
        return Pair(true, false)
    }
    return Pair(false, false)
}

//@Preview(showBackground = true)
@Composable
fun Quiz (
    navController: NavHostController
){
//    fun onSubmitQuiz() {
//        navController.navigate("quiz_score_screen")
//    }
    var revealedHint by remember { mutableStateOf(0) }
    var currentIndex by remember { mutableStateOf(0) }
    var correctQuestions by remember { mutableStateOf(0) }
    var doneQuestions by remember { mutableStateOf(0) }
    var isWrong by remember { mutableStateOf(false) }
    val totalQuestions = Questions.size

    // Reset revealedHint whenever currentIndex changes
    LaunchedEffect(currentIndex) {
        revealedHint = 0 // Reset revealed hints for the new question
    }

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
                .padding(top = 40.dp, bottom = 25.dp)
        ){
            Text(text = "Quiz",
                fontSize = 36.sp
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
//            var revealedHint by remember { mutableStateOf(0) }

            // Calculate the remaining hints

            HintButton(
                hints = Questions[currentIndex].Hints,
                currentIndex = currentIndex,
                onRevealHint = {
                    if (revealedHint < Questions[currentIndex].Hints.size) {
                        revealedHint++  // Increase the revealed hint count when the button is clicked
                    }
                },
                remaining = Questions[currentIndex].Hints.size - revealedHint
            )
            Spacer(modifier = Modifier.weight(2f))
//            Column {
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
//                        text = "1/5",
                        text = "${correctQuestions}/${totalQuestions}",
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
        Row {
            QuizPage(
                quizList = Questions,
                currentIndex = currentIndex,
                onIndexChange = { newIndex -> currentIndex = newIndex },
                modifier = Modifier,
//                    .weight(10f),
                isWrong = isWrong,
//                onSubmitQuiz = ::onSubmitQuiz
            )
        }
        var text by remember { mutableStateOf("") }
        Row (){
            OutlinedTextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text("Enter your answer") },
                modifier = Modifier
//                .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp)
                    .padding(bottom = 10.dp)
                    .height(60.dp)

            )
        }
        Row {
            Spacer(modifier = Modifier.weight(2f))
            Button(
                onClick = {
                   val (isCorrect, correctAgain) = Check(currentIndex, text.trim())
                    if(isCorrect&&!correctAgain){
                        correctQuestions++
                        text = ""
                        if(currentIndex<Questions.size-1){
                            currentIndex++
                        }
                        isWrong = false
//                        onIndexChange(currentIndex)
                    }
                    else if(!isCorrect){
                        isWrong = true
                        text = ""
                    }

                    if(currentIndex>=Questions.size){
                        navController.navigate("quiz_score_screen/${correctQuestions}/${totalQuestions}")
                    }
                },
                modifier = Modifier
                    .padding(bottom = 10.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF33B4FF),
                )
            ){
                Text(text = "Check")
            }
        }
//        Spacer(modifier = Modifier.weight(1f))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
//                .heightIn(max = 500.dp)
                .weight(15f)
        ){
                Box(modifier = Modifier.weight(1f)){
                    HintList(
                        revealedHint = revealedHint,
                        quizList = Questions,
                        currentIndex = currentIndex
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center //only works if the row fills the entire width
            ) {
                PaginationDots(
                    totalDots = Questions.size,
                    currentIndex = currentIndex,
                    onIndexChange = { newIndex -> currentIndex = newIndex },
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }


@Preview(showBackground = true)
@Composable
fun QuizPreview(){
    Quiz(navController = NavHostController(LocalContext.current))

}