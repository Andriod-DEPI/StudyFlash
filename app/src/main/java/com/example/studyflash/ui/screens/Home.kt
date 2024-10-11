@file:Suppress("PreviewAnnotationInFunctionWithParameters")

package com.example.studyflash.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.studyflash.ui.components.TopBar

@Preview(showBackground = true)
@Composable
fun HomeScreen(navController: NavHostController){
    Text(text = "Home Screen")
    Scaffold(
        topBar = { TopBar(navController = navController) },
        content = {paddingValues ->
            // Main content of the screen goes here
            // paddingValues is passed in to adjust the content to avoid overlap with other elements
            Text(
                text = "Hello, Scaffold!",
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}