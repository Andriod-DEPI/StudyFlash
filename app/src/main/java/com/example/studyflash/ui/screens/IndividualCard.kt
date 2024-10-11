package com.example.studyflash.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.studyflash.R
import com.example.studyflash.classes.Card
import com.example.studyflash.ui.composables.CardItem
import com.example.studyflash.viewmodels.CategoryCardViewModel

@Composable
fun IndividualCardScreen(navController: NavController, catId:Int?, cardID:Int?) {
    val viewModel: CategoryCardViewModel = hiltViewModel()
    viewModel.loadCategories()
    viewModel.loadCardsForCategory(catId!!)
    val cards by viewModel.Cards.collectAsState()
    IndividualCardContent(cards,cardID,{navController.popBackStack()}, onUpdateCard = viewModel::updateCard)
}

@Composable
fun IndividualCardContent(cards:List<Card>,cardID: Int?, onBackclick:()->Unit, onUpdateCard:(Card)->Unit){
    val card = cards.find { it.id == cardID }
    var index by rememberSaveable {
        mutableStateOf(cards.indexOf(card))
    }
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
                .clickable {
                    onBackclick()
                }
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
            CardItem(cards[index],
                Modifier
                    .width(256.dp)
                    .height(400.dp)
                    .weight(4f))
            Image(
                painter = painterResource(id = R.drawable.next_card_icon),
                contentDescription = "Go to Previous Card",
                modifier = Modifier
                    .height(400.dp)
                    .weight(1f)
                    .clickable {
                        if (index < cards.size - 1) {
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
                        // update in firebase
                        cards[index].isChecked = false
                        onUpdateCard(cards[index])

                        if (index < cards.size - 1) {
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
                    .clickable {
                        // update in firebase
                        cards[index].isChecked = true
                        onUpdateCard(cards[index])

                        if (index < cards.size - 1) {
                            index++
                        }
                        // increase user's score
                    }
            )

        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun previewIndividualCard(){
    val cards = listOf(
        Card(1,1, "Title1", "content 1", 1, false),
        Card(2,1, "Title2", "content 2", 2, false),
        Card(3,1, "Title3", "content 1", 3, false),
        Card(4,1, "Title4", "content 2", 4, false),
        Card(5,1, "Title5", "content 1", 5, false),
        Card(6,1, "Title6", "content 2", 6, false),
    )
    IndividualCardContent(cards = cards, cardID = 1 , {}) {
        
    }
}