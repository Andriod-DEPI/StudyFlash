package com.example.studyflash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.studyflash.ui.navigation.NavHostGraph
import com.example.studyflash.ui.theme.StudyFlashTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            StudyFlashTheme {
                // Create a NavController instance
                val navController = rememberNavController()

                // Pass it to the NavHostGraph Composable
                NavHostGraph(navController = navController)
            }
        }
    }
}