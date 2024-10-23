package com.example.studyflash.ui.navigation

import com.example.studyflash.viewmodels.LoginViewModel
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
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
import com.example.studyflash.ui.screens.Loginscreen
import com.example.studyflash.ui.screens.SignupScreen


@Composable
fun NavHostGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(navController = navController, startDestination = "landPage") {

        composable("logIn") {
            val loginViewModel: LoginViewModel = viewModel()
            Loginscreen(viewModel = loginViewModel, navController = navController)
        }
        composable("signUp") {
            SignupScreen(
                navController = navController,
                onSignInClick = { navController.navigate("logIn") })
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
            Add_Edit_Category(navController, 0)
        }

        composable("addCard/{catId}", arguments = listOf(
            navArgument("catId") { // Changed categId to catId
                type = NavType.IntType
            }
        )) {
            val catID = it.arguments?.getInt("catId") // Changed categId to catId
            Add_Edit_Card_Screen(navController, catID)
        }

        composable("editCategory/{catId}", arguments = listOf(
            navArgument("catId") { // Ensure consistency
                type = NavType.IntType
            }
        )) {
            val catID = it.arguments?.getInt("catId")
            Add_Edit_Category(navController, catID)
        }

        composable("editCard/{cardId}", arguments = listOf(
            navArgument("cardId") {
                type = NavType.IntType
            }
        )) {
            val cardID = it.arguments?.getInt("cardId")
            Add_Edit_Card_Screen(navController, cardID)
        }

        composable("individualCard/{cardId}", arguments = listOf(
            navArgument("cardId") {
                type = NavType.IntType
            }
        )) {
            val cardID = it.arguments?.getInt("cardId")
            IndividualCardScreen(navController, cardID)
        }

        composable("CardsList/{catId}", arguments = listOf(
            navArgument("catId") { // Changed categId to catId
                type = NavType.IntType
            }
        )) {
            val catID = it.arguments?.getInt("catId") // Changed categId to catId
            CardsListScreen(navController, catID)
        }
    }
}
