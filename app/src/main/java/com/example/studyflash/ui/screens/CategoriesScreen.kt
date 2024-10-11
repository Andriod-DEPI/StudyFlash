package com.example.studyflash.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.studyflash.ui.components.TopBar

@Composable
fun CategoriesScreen(navController: NavHostController) {
    Text(text = "Categories Screen")
    Scaffold (
        topBar = { TopBar(navController = navController) },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // Add your action here
                },
                containerColor = Color(0xFF6A31F7), // FAB background color
                contentColor = Color.White           // Icon color inside FAB
            ) {
                Icon(
                    imageVector = Icons.Default.Add,  // Use the plus icon
                    contentDescription = "Add Icon",
                    modifier = Modifier.size(35.dp)
                )
            }
        },
        content = { paddingValues ->
            // Main content of the screen goes here
            // paddingValues is passed in to adjust the content to avoid overlap with other elements
            Column (modifier = Modifier.padding(paddingValues)){
                Text(
                    text = "Categories",
                    fontSize = 24.sp,
//                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                    modifier = Modifier
//                        .padding(paddingValues)
                        .padding(top = 20.dp, start = 20.dp)
                )
                CategoriesList()
            }
        }

    )
}

@Preview(showBackground = true)
@Composable
fun CategoriesScreenPreview() {
    CategoriesScreen(navController = rememberNavController())
}



