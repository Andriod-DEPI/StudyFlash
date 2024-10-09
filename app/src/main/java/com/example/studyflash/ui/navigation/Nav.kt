package com.example.studyflash.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.studyflash.ui.screens.Add_Edit_Card_Screen
import com.example.studyflash.ui.screens.Add_Edit_Category
import com.example.studyflash.ui.screens.CardsListScreen
import com.example.studyflash.ui.screens.CategoriesScreen
import com.example.studyflash.ui.screens.HomePage
import com.example.studyflash.ui.screens.IndividualCardScreen
import com.example.studyflash.ui.screens.LandPage
import com.example.studyflash.ui.screens.LogIn
import com.example.studyflash.ui.screens.SignIn



@Composable
fun NavHostGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(navController = navController, startDestination = "landPage") {

        composable("logIn") {
            LogIn(navController = navController)
        }
        composable("SignIn") {
            SignIn(navController = navController)
        }
        composable("landPage") {
            LandPage(navController = navController)
        }
        composable("homePage") {
            HomePage(navController = navController)
        }
        composable("categories") {
            CategoriesScreen(navController)
        }
        composable("addCategory") {
            Add_Edit_Category()
        }
        composable("addCard") {
            Add_Edit_Card_Screen()
        }
        composable("editCategory/{catId}", arguments = listOf(
            navArgument("categId") {
                NavType.IntType
            }
        )) {
            Add_Edit_Category()
        }
        composable("editCard/{cardId}",arguments = listOf(
            navArgument("cardId") {
                NavType.IntType
            }
        )) {
            Add_Edit_Card_Screen()
        }

        composable("individual Card/{cardId}", arguments = listOf(
            navArgument("cardId") {
                NavType.IntType
            }
        )) {
            IndividualCardScreen()
        }
        composable("Cards List/{categId}", arguments = listOf(
            navArgument("categId") {
                NavType.IntType
            }
        )) {
            CardsListScreen()
        }
    }
}