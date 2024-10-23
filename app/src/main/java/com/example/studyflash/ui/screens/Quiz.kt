package com.example.studyflash.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyflash.R
import com.example.studyflash.ui.components.HintButton
import com.example.studyflash.ui.components.HintList
import com.example.studyflash.ui.components.Hints
import com.example.studyflash.ui.components.PaginationDots
import com.example.studyflash.ui.components.QuizPage
import com.example.studyflash.viewmodels.Questions


fun Check(currentIndex: Int, userAns: String): Boolean{
    var ans = Questions[currentIndex].Answer.toLowerCase()
    var isCorrect: Boolean = false
    if(userAns.toLowerCase() == ans){
        Questions[currentIndex].IsDone = true
        Questions[currentIndex].isCorrect = true
        return true
    }
    else{
        Questions[currentIndex].IsDone = true
        Questions[currentIndex].isCorrect = false
        return false
    }
}

@Preview(showBackground = true)
@Composable
fun Quiz (){
    var revealedHint by remember { mutableStateOf(0) }
    var currentIndex by remember { mutableStateOf(0) }
    var correctQuestions by remember { mutableStateOf(0) }
    var isWrong by remember { mutableStateOf(false) }
    val totalQuestions = 10
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
                .padding(top = 45.dp, bottom = 30.dp)
        ){
            Text(text = "Quiz",
                fontSize = 36.sp
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            var revealedHint by remember { mutableStateOf(0) }

            // Calculate the remaining hints

            HintButton(
                hints = Questions[currentIndex].Hints,
                currentIndex = currentIndex,
                onRevealHint = {
                    if (revealedHint < Hints.size) {
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
                modifier = Modifier.weight(1f),
                isWrong = isWrong
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
            )
        }
        Row {
            Spacer(modifier = Modifier.weight(2f))
            Button(
                onClick = {
                   val isCorrect = Check(currentIndex, text)
                    if(isCorrect){
                        correctQuestions++
                        text = ""
                        if(currentIndex<Questions.size-1){
                            currentIndex++
                        }
                        isWrong = false
//                        onIndexChange(currentIndex)
                    }
                    else{
                        isWrong = true
                    }
                },
                modifier = Modifier
                    .padding(bottom = 10.dp)
            ){
                Text(text = "Check")
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        Column (
        ){
            Column (
                modifier = Modifier
                    .heightIn(max = 200.dp)
            ){
                HintList(revealedHint = revealedHint, quizList = Questions, currentIndex = currentIndex)
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
}

