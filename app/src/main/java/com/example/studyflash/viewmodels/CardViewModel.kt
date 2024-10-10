package com.example.studyflash.viewmodels

import androidx.lifecycle.ViewModel
import com.example.studyflash.classes.Card
import com.example.studyflash.repositories.CardRepository
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
import com.example.studyflash.ui.theme.Yellow
import com.example.studyflash.ui.theme.YellowStroke

class CardViewModel:ViewModel() {
    // instance of repo
    // cards : list<Card>
    var cards:List<Card> = listOf()

}