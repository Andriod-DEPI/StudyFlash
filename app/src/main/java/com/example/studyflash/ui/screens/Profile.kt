package com.example.studyflash.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.studyflash.ui.components.TopBar

@Composable
fun ProfileScreen(navController: NavHostController){
    Scaffold (
        topBar = { TopBar(navController = navController) },
        content = { paddingValues ->
            // Main content of the screen goes here
            // paddingValues is passed in to adjust the content to avoid overlap with other elements
            Text(text = "Profile Screen", modifier = Modifier.padding(paddingValues))
        }
    )
}