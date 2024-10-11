package com.example.studyflash.viewmodels

import androidx.lifecycle.ViewModel
import com.example.studyflash.classes.Card

class CardViewModel:ViewModel() {
    // instance of repo
    // cards : list<Card>
    var cards:List<Card> = listOf()

}