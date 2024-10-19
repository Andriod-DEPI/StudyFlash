package com.example.studyflash.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.studyflash.ui.components.QuizCard

@Preview(showBackground = true)
@Composable
fun Quiz (){
    var revealedHint by remember { mutableStateOf(0) }
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
                .padding(top = 40.dp, bottom = 20.dp)
        ){
            Text(text = "Quiz",
                fontSize = 36.sp
            )
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            HintButton(hints = Hints) {
                if (revealedHint < Hints.size) {
                    revealedHint++
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
        Row {
            QuizCard()
        }
        Row {
            Spacer(modifier = Modifier.weight(2f))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .padding(0.dp)
            ){
                Text(text = "Check")
            }
        }
        Spacer(modifier = Modifier.weight(2f))
        Row {
            HintList(revealedHint = revealedHint)
        }
        Row {

        }
    }
}

