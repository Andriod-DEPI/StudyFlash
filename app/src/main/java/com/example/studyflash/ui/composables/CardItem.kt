package com.example.studyflash.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyflash.classes.Card
import com.example.studyflash.ui.colors.Colors
import com.example.studyflash.ui.theme.AlexandriaFamily
import com.example.studyflash.ui.theme.Green

@Composable
fun CardItem(card: Card, boxModifier:Modifier){
    Box(
        boxModifier
            .background(color = Colors.getColorById(card.colorID).color, shape = RoundedCornerShape(16.dp))
            .border(
                3.dp,
                Colors.getColorById(card.colorID).strokeColor, shape = RoundedCornerShape(16.dp)
            )

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(25.dp)
        ) {
            Text(
                text = card.title,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 30.sp,
                color = Colors.getColorById(card.colorID).strokeColor,
                fontFamily = AlexandriaFamily,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = card.content,
                fontFamily = AlexandriaFamily,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                modifier = Modifier.fillMaxSize(),
                color = Color.DarkGray
            )

        }
    }

}

@Preview(showSystemUi = true)
@Composable
fun cradPreview(){
    val card = Card(1, "Title", "content", 1, false)
    CardItem(card = card, boxModifier = Modifier)
}