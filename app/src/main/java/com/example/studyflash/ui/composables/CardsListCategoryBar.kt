package com.example.studyflash.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyflash.R
import com.example.studyflash.classes.Card
import com.example.studyflash.classes.Category
import com.example.studyflash.ui.theme.Blue
import com.example.studyflash.ui.theme.BlueStroke
import com.example.studyflash.ui.theme.Brown
import com.example.studyflash.ui.theme.BrownStroke
import com.example.studyflash.ui.theme.DarkGreen
import com.example.studyflash.ui.theme.Green
import com.example.studyflash.ui.theme.Pink
import com.example.studyflash.ui.theme.PinkStroke
import com.example.studyflash.ui.theme.Purple
import com.example.studyflash.ui.theme.PurpleStroke
import com.example.studyflash.ui.theme.ReadexProFamily
import com.example.studyflash.ui.theme.RedRoseFamily
import com.example.studyflash.ui.theme.Yellow
import com.example.studyflash.ui.theme.YellowStroke


@Composable
fun SelectedCategory(category: Category){
     Row (
        Modifier
            .fillMaxWidth()
            .padding(8.dp) , horizontalArrangement = Arrangement.SpaceBetween){

  Row {
      Image(painter = painterResource(id = R.drawable.category_ic), contentDescription = null, modifier = Modifier.size(24.dp) )
      Spacer(modifier = Modifier.width(5.dp))
      Text(text = category.name, fontSize = 20.sp , fontWeight = FontWeight.Bold,
//          fontFamily = RedRoseFamily
      )

  }
        Row {
            Text(text = "${category.progress}/${category.cards.size}",fontSize = 20.sp , fontWeight = FontWeight.Bold,
//                fontFamily = ReadexProFamily
            )
            Spacer(modifier = Modifier.width(5.dp))
            Image(painter = painterResource(id = R.drawable.cards_ic), contentDescription = null, Modifier.size(25.dp))
        }
    }
}