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
import com.example.studyflash.ui.screens.HomeScreen
import com.example.studyflash.ui.screens.IndividualCardScreen
import com.example.studyflash.ui.screens.ProfileScreen

@Composable
fun NavHostGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
        }
        composable("categories") {
            CategoriesScreen(navController)
        }
        composable("profile") {
            ProfileScreen(navController)
        }



        composable("addCategory") {
            Add_Edit_Category(navController, 0)
        }


        composable("addCard/{catId}",arguments = listOf(
            navArgument("categId") {
                NavType.IntType
            }
        )) {
            val catID = it.arguments?.getInt("categId")
            Add_Edit_Card_Screen(navController, catID)
        }
        composable("editCategory/{catId}", arguments = listOf(
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