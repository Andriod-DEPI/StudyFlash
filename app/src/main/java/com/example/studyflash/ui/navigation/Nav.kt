package com.example.studyflash.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.studyflash.ui.screens.CategoriesScreen
import com.example.studyflash.ui.screens.HomeScreen
import com.example.studyflash.ui.screens.LandingPage
import com.example.studyflash.ui.screens.ProfileScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(navController = navController, startDestination = "landing") {
        composable("landing") {
            LandingPage(navController)
        }
        composable("home") {
            HomeScreen(navController)
        }
        composable("categories") {
            CategoriesScreen(navController)
        }
        composable("profile") {
            ProfileScreen(navController)
        }
//  ----------------------------------------
//        composable("addCategory") {
//            Add_Edit_Category()
//        }
//        composable("addCard") {
//            Add_Edit_Card_Screen()
//        }
//        composable("editCategory/{catId}", arguments = listOf(
//            navArgument("categId") {
//                NavType.IntType
//            }
//        )) {
//            Add_Edit_Category()
//        }
//        composable("editCard/{cardId}",arguments = listOf(
//            navArgument("cardId") {
//                NavType.IntType
//            }
//        )) {
//            Add_Edit_Card_Screen()
//        }
//
//        composable("individual Card/{cardId}", arguments = listOf(
//            navArgument("cardId") {
//                NavType.IntType
//            }
//        )) {
//            IndividualCardScreen()
//        }
//        composable("Cards List/{categId}", arguments = listOf(
//            navArgument("categId") {
//                NavType.IntType
//            }
//        )) {
//            CardsListScreen()
//        }
    }
}