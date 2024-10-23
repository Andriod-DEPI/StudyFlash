package com.example.studyflash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
//import com.example.studyflash.ui.navigation.NavHostGraph
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.studyflash.ui.navigation.NavGraph
import com.example.studyflash.ui.theme.StudyFlashTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)

        val sharedPreferences = getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
        val isFirstLaunch = sharedPreferences.getBoolean("isFirstLaunch", true)

        if (isFirstLaunch) {
            setLocale(this, "en")

            sharedPreferences.edit().putBoolean("isFirstLaunch", false).apply()

            recreate()
        }

        Firebase.auth
        enableEdgeToEdge()
        setContent {
            StudyFlashTheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavGraph(navController = navController,activity = this
                    modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StudyFlashTheme {
        Greeting("Android")
    }
}

//@Composable
//fun NavGraph(navController: NavHostController, modifier: Modifier){
//    NavHost(
//        navController = navController,
//        startDestination = "landing"
//    ) {
//        composable("landing") {
//            LandingPage(navController = navController)
//        }
//        composable("home") {
//            HomeScreen(navController = navController)
//        }
//    }
//}
