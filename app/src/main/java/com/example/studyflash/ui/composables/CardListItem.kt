package com.example.studyflash.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import com.example.studyflash.R
import com.example.studyflash.classes.Card
import com.example.studyflash.ui.colors.Colors
import com.example.studyflash.ui.theme.AlexandriaFamily

@Composable
@Preview (showSystemUi = true)
fun preview(){
    CardListItem(card = (  Card("1","1", "Title1", "content 1", 1, true)),{},{},{})
}


@Composable
fun CardListItem(card: Card, onCardClick:()->Unit, onEditClick:()->Unit, onDeleteClick:()->Unit){
    var showMenu by remember {
        mutableStateOf(false)
    }
    var expanded  by remember {
        mutableStateOf(false)
    }

    Box(
        Modifier
            .width(180.dp)
            .height(215.dp)
            .padding(0.dp)
            .background(
                color = Colors.getColorById(card.colorID).color,
                shape = RoundedCornerShape(16.dp)
            )
            .border(
                3.dp,
                Colors.getColorById(card.colorID).strokeColor, shape = RoundedCornerShape(16.dp)
            )
            .pointerInput(true) {
                detectTapGestures(
                    onLongPress = {
                        showMenu = true
                        expanded = true
                    }, onTap = { onCardClick() }
                )
            }
    ) {

        if (showMenu) {
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                properties = PopupProperties(focusable = false,
                    dismissOnBackPress = true,
                    dismissOnClickOutside = true)
            ) {
                DropdownMenuItem(onClick = {
                    // Call your first function here
                    expanded = false

                    onEditClick()

                }) {
                    Text("Edit")
                }
                DropdownMenuItem(onClick = {
                    // Call your second function here
                    expanded = false
                    onDeleteClick()

                }) {
                    Text("Delete")
                }
            }

        }


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
                fontSize = 25.sp,
                color = Colors.getColorById(card.colorID).strokeColor,
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