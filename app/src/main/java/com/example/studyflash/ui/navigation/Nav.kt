package com.example.studyflash.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.studyflash.ui.screens.Add_Edit_Card_Screen
import com.example.studyflash.ui.screens.Add_Edit_Category
import com.example.studyflash.ui.screens.CardsListScreen
import com.example.studyflash.ui.screens.CategoriesScreen
import com.example.studyflash.ui.screens.HomePage
import com.example.studyflash.ui.screens.IndividualCardScreen
import com.example.studyflash.ui.screens.LandPage
import com.example.studyflash.ui.screens.LogIn
import com.example.studyflash.ui.screens.ProfilePage
import com.example.studyflash.ui.screens.QuizScreen
import com.example.studyflash.ui.screens.SignIn


@Composable
fun NavGraph(
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
        composable("homePage") {
            HomePage(navController = navController)
        }
        composable("categories") {
            CategoriesScreen(navController)
        }
        composable("profile") {
            ProfilePage(navController)
        }
        composable("landPage") {
            LandPage(navController = navController)
        }
        composable("addCategory") {
            Add_Edit_Category(navController, 0)
        }
        composable("quiz"){
            QuizScreen()
        }


        composable("addCard/{categId}",arguments = listOf(
            navArgument("categId") {
                NavType.IntType
            }
        )) {
            val catID = it.arguments?.getInt("categId")
            Add_Edit_Card_Screen(navController, catID)
        }
        composable("editCategory/{categId}", arguments = listOf(
            navArgument("categId") {
                NavType.IntType
            }
        )) {
            val catID = it.arguments?.getInt("categId")
            Add_Edit_Category(navController, catID)
        }
        composable("editCard/{cardId}",arguments = listOf(
            navArgument("cardId") {
                NavType.IntType
            }
        )) {
            val cardID = it.arguments?.getInt("cardId")
            Add_Edit_Card_Screen(navController, cardID)
        }

        composable("individual Card/{cardId}", arguments = listOf(
            navArgument("cardId") {
                NavType.IntType
            }
        )) {
            val cardID = it.arguments?.getInt("cardId")
            IndividualCardScreen(navController, cardID)
        }
        composable("Cards List/{categId}", arguments = listOf(
            navArgument("categId") {
                NavType.IntType
            }
        )) {
            val catID = it.arguments?.getInt("categId")
            CardsListScreen(navController, catID)
        }
    }
}