package com.example.studyflash.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyflash.R
import com.example.studyflash.ui.theme.BackgroundColor
import com.example.studyflash.ui.theme.DarkGreen
import com.example.studyflash.ui.theme.Green
import com.example.studyflash.ui.theme.PrimaryColor
data class Card(val id:Int, val title:String, val content:String, val color:Color, val cardStroke:Color, var isChecked:Boolean)
@Preview(showSystemUi = true)
@Composable
fun IndividualCardScreen() {
    val cards = listOf(
        Card(1,"Title1", "content 1", Green, DarkGreen, false ),
        Card(2,"Title2", "content 2", Color.Cyan, Color.Blue, false )

    )
    IndividualCardContent(cards)
}

@Composable
fun IndividualCardContent(cards:List<Card>){
    var index by rememberSaveable {
        mutableStateOf(0)
    }

    var CardColor = cards[index].color
    var CardStroke = cards[index].cardStroke
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.individual_card_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
    Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(25.dp))
        Image(
            painter = painterResource(id = R.drawable.back_icon),
            contentDescription = "Back Icon",
            modifier = Modifier
                .size(50.dp)
                .fillMaxWidth()
                .align(Alignment.Start)
                .padding(horizontal = 5.dp)
                .clickable { }
        )
        Spacer(modifier = Modifier.height(50.dp))
        Row {
            Image(
                painter = painterResource(id = R.drawable.previous_card_icon),
                contentDescription = "Go to Previous Card",
                modifier = Modifier
                    .height(400.dp)
                    .weight(1f)
                    .clickable {
                        if (index > 0) {
                            index--
                        }
                    }
            )
            Box(
                Modifier
                    .width(256.dp)
                    .height(400.dp)
                    .background(color = CardColor, shape = RoundedCornerShape(16.dp))
                    .border(
                        3.dp,
                        CardStroke, shape = RoundedCornerShape(16.dp)
                    )
                    .weight(4f)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(25.dp)
                ) {
                    Text(
                        text = cards[index].title,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        color = DarkGreen,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = cards[index].content,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 18.sp,
                        modifier = Modifier.fillMaxSize()
                    )

                }
            }
            Image(
                painter = painterResource(id = R.drawable.next_card_icon),
                contentDescription = "Go to Previous Card",
                modifier = Modifier
                    .height(400.dp)
                    .weight(1f)
                    .clickable {
                        if (index < cards.size-1) {
                            index++
                        }
                    }
            )
        }
        Spacer(modifier = Modifier.height(80.dp))
        Row(Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.wrong_icon),
                contentDescription = "Not Memorized Card",
                modifier = Modifier
                    .size(100.dp)
                    .weight(1f)
                    .clickable {
                        cards[index].isChecked = false
                        if (index < cards.size-1) {
                            index++
                        }
                    }
            )
            Image(
                painter = painterResource(id = R.drawable.right_icon),
                contentDescription = "Not Memorized Card",
                modifier = Modifier
                    .size(100.dp)
                    .weight(1f)
                    .clickable { cards[index].isChecked = true
                        if (index < cards.size-1) {
                            index++
                        }
                    }
            )

        }

    }
}