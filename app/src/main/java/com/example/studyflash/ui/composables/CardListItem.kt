package com.example.studyflash.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyflash.ui.classes.Card
import com.example.studyflash.ui.theme.DarkGreen
import com.example.studyflash.ui.theme.Green

@Composable
fun CardListItem(card:Card){
    Box(
        Modifier.width(100.dp)
            .height(228.dp)
            .padding(10.dp)
            .background(color = card.color, shape = RoundedCornerShape(16.dp))
            .border(
                3.dp,
                card.cardStroke, shape = RoundedCornerShape(16.dp)
            )

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp),
            verticalArrangement = Arrangement.Center

        ) {
            Text(
                text = card.title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = card.cardStroke,
                fontWeight = FontWeight.Bold
            )

        }
    }
}