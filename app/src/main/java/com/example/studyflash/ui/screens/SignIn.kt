package com.example.studyflash.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.studyflash.ui.theme.StudyFlashTheme


@Composable
fun SignIn(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Sign In page")
        Button(onClick = {
            navController.navigate("homePage")
        }) {
            Text(text = "create account")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSignIn() {
    StudyFlashTheme {
        SignIn(navController = rememberNavController())
    }
}