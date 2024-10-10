package com.example.studyflash.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyflash.R
import com.example.studyflash.classes.Card
import com.example.studyflash.ui.theme.AlexandriaFamily
import com.example.studyflash.ui.theme.DarkGreen
import com.example.studyflash.ui.theme.Green
@Composable
@Preview (showSystemUi = true)
fun preview(){
    CardListItem(card = (  Card(1,"Title1", "content 1", Green, DarkGreen, true )),{})
}


@Composable
fun CardListItem(card: Card, onCardClick:()->Unit){
    Box(
        Modifier
            .width(180.dp)
            .height(215.dp)
            .padding(0.dp)
            .background(color = card.color, shape = RoundedCornerShape(16.dp))
            .border(
                3.dp,
                card.cardStroke, shape = RoundedCornerShape(16.dp)
            ).clickable {
                onCardClick()
            }

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp, 0.dp),
            verticalArrangement = Arrangement.Center

        ) {
            if(card.isChecked) Spacer(modifier = Modifier.height(70.dp))

            Text(
                text = card.title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = card.cardStroke,
                fontFamily = AlexandriaFamily,
                fontWeight = FontWeight.Bold,
            )

            if(card.isChecked){
                Spacer(modifier = Modifier.height(60.dp))
                Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End){
                    Image(painter = painterResource(id =  R.drawable.checked_card_ic), contentDescription = "checked card", modifier = Modifier.size(30.dp) )
                }
            }

        }
    }
}