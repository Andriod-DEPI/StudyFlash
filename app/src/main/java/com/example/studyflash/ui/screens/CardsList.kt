package com.example.studyflash.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.studyflash.R
import com.example.studyflash.classes.Card
import com.example.studyflash.classes.Category
import com.example.studyflash.ui.composables.CardListItem
import com.example.studyflash.ui.composables.SelectedCategory
import com.example.studyflash.ui.theme.BackgroundColor
import com.example.studyflash.ui.theme.PrimaryColor

@Composable
fun CardsListScreen(
    navController: NavController, catID: Int?
) {
    //get category by id

    val category = Category(
        1, "Technology", 1, listOf(
            Card(1,1, "Title1", "content 1", 1, false),
            Card(2,1, "Title2", "content 2", 2, true),

            Card(3,1, "Title3", "content 1", 3, true),
            Card(4,1, "Title4", "content 2", 4, false),

            Card(5,1, "Title5", "content 1", 5, false),
            Card(6,1, "Title6", "content 2", 6, false),

            Card(1,1, "Title1", "content 1", 1, false),
            Card(2,1, "Title2", "content 2", 2, false),

            Card(3,1, "Title3", "content 1", 3, false),
            Card(4,1, "Title4", "content 2", 4, false),

            Card(5,1, "Title5", "content 1", 5, false),
            Card(6,1, "Title6", "content 2", 6, true),
        ), 3
    )
    val cards = category.cards
    Column(Modifier.background(BackgroundColor)) {
        SelectedCategory(category = category)
        LazyVerticalGrid(
            columns = GridCells.Fixed(2), // 2 columns
            contentPadding = PaddingValues(20.dp, 3.dp),
            horizontalArrangement = Arrangement.spacedBy(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(cards) {
                CardListItem(it) {
                    navController.navigate("individual Card/${it.id}")
                }
            }
        }

        Row(
            horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
              navController.navigate("")
                },
                Modifier
                    .height(50.dp),
                shape = RoundedCornerShape(20.dp),
                colors = ButtonDefaults.buttonColors().copy(containerColor = PrimaryColor)
            )
            {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.quiz_ic),
                        contentDescription = "quiz icon",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(5.dp))
                    Text(
                        text = "Start Quiz",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = BackgroundColor
                    )

                }
            }

            FloatingActionButton(onClick = {
              navController.navigate("addCard/$catID")
            }, containerColor = PrimaryColor, contentColor = BackgroundColor) {
                Text(text = "+", fontSize = 40.sp, color = BackgroundColor)
            }
        }
    }
}
