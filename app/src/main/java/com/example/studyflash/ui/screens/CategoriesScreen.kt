package com.example.studyflash.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun CategoriesScreen(navController: NavController) {
    Text(text = "Categories Screen")

}

@Preview(showBackground = true)
@Composable
fun CategoriesScreenPreview() {
    HomeScreen(navController = rememberNavController())
}