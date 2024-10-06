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
    init {
         cards = listOf(
            Card(1,"Title1", "content 1", Green, DarkGreen, false ),
            Card(2,"Title2", "content 2", Yellow, YellowStroke , false ),

            Card(3,"Title3", "content 1", Pink, PinkStroke, false ),
            Card(4,"Title4", "content 2", Brown, BrownStroke, false ),

            Card(5,"Title5", "content 1", Purple, PurpleStroke, false ),
            Card(6,"Title6", "content 2", Blue, BlueStroke, false ),

            )
    }
}