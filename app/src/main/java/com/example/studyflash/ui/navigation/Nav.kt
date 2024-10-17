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
import com.example.studyflash.ui.screens.SignIn


@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {

    NavHost(navController = navController, startDestination = "landPage") {
       composable("logIn") {
            // Create or retrieve an instance of LoginViewModel
            val loginViewModel: LoginViewModel = viewModel()

            // Pass the NavController to Loginscreen
            Loginscreen(viewModel = loginViewModel, navController = navController)
        }
        composable("signUp") {
            SignupScreen(
                navController = navController,
                onSignInClick = { navController.navigate("logIn") })
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
            Add_Edit_Category(navController, null)
        }


        composable("addCard/{categId}", arguments = listOf(
            navArgument("categId") {
               type = NavType.IntType
            }
        )) {backStack->
            val catID = backStack.arguments?.getInt("categId")
            catID?.let { Add_Edit_Card_Screen(navController, catID, null) }
        }
        composable("editCategory/{categId}", arguments = listOf(
            navArgument("categId") {
                type = NavType.IntType
            }
        )) {
            val catID = it.arguments?.getInt("categId")
            Add_Edit_Category(navController, catID)
        }
        composable("editCard/{catId}/{cardId}", arguments = listOf(
            navArgument("catId") {
                type = NavType.IntType
            },
            navArgument("cardId") {
                type = NavType.IntType
            }
        )) {
            val cardID = it.arguments?.getInt("cardId")
            val catId = it.arguments?.getInt("catId")
            Add_Edit_Card_Screen(navController, catId, cardID)
        }

        composable("individual Card/{catId}/{cardId}", arguments = listOf(
            navArgument("catId") {
               type = NavType.IntType
            },
            navArgument("cardId") {
               type=  NavType.IntType
            }
        )) {
            val catId = it.arguments?.getInt("catId")
            val cardID = it.arguments?.getInt("cardId")
            IndividualCardScreen(navController, catId, cardID)
        }
        composable("Cards List/{categId}", arguments = listOf(
            navArgument("categId") {
                type = NavType.IntType
            }
        )) {backStack->
            val catID = backStack.arguments?.getInt("categId")
            catID?.let { CardsListScreen(navController, catID) }
        }
    }
}
