package com.example.studyflash.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

//@Preview(showBackground = true)
//@Composable
//fun TopNavBarPreview() { // Create a separate function for preview
//    TopNavBar()
//}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
//unit means a function that returns void
fun TopNavBar(
    onHomeClick: () -> Unit ={},
    onProfileClick: () -> Unit ={},
    onCategoriesClick: () -> Unit ={},
){
    TopAppBar(
        title = { Text(text = "StudyFlash") },
        actions = {
           Row {
               IconButton(onClick = onHomeClick) {
                   Icon(Icons.Filled.Home, contentDescription = "Home")
               }
               IconButton(onClick = onProfileClick) {
                   Icon(Icons.Filled.Person, contentDescription = "Profile")
               }
               IconButton(onClick = onCategoriesClick) {
                   Icon(Icons.Filled.Build, contentDescription = "Categories")
               }
           }
        },
    )}

