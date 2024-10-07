package com.example.studyflash.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyflash.viewmodels.Category

val items = listOf(
    Category("Math", numberOfCards = 10, numberOfCompleted = 5),
    Category("Science", numberOfCards = 15, numberOfCompleted = 8),
    Category("History", numberOfCards = 20, numberOfCompleted = 12),
    Category("Art", numberOfCards = 5, numberOfCompleted = 2)
)

@Preview
@Composable
fun CategoriesScreen() {
    LazyColumn {
        items(items){
            item -> Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp) // Adjust padding as needed
        ) {
            Text(text = "Category: ${item.name}", fontSize = 20.sp)
            Text(text = "Number of Cards: ${item.numberOfCards}", fontSize = 16.sp)
            Text(text = "Number Completed: ${item.numberOfCompleted}", fontSize = 16.sp)
            Spacer(modifier = Modifier.height(8.dp)) // Space between items
        }
        }
    }
}

