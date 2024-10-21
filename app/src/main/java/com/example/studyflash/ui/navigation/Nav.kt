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

    NavHost(navController = navController, startDestination = "Cards List/7OII0IKTEupmw59kPcvy") {
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
            Add_Edit_Category(navController, null)
        }


        composable("addCard/{categId}", arguments = listOf(
            navArgument("categId") {
               type = NavType.StringType
            }
        )) {backStack->
            val catID = backStack.arguments?.getString("categId")
            catID?.let { Add_Edit_Card_Screen(navController, catID, null) }
        }
        composable("editCategory/{categId}", arguments = listOf(
            navArgument("categId") {
                type = NavType.StringType
            }
        )) {backStack->
            val catID = backStack.arguments?.getString("categId")
            catID?.let { Add_Edit_Category(navController, catID) }
        }
        composable("editCard/{catId}/{cardId}", arguments = listOf(
            navArgument("catId") {
                type = NavType.StringType
            },
            navArgument("cardId") {
                type = NavType.StringType
            }
        )) {backStack->
            val cardID = backStack.arguments?.getString("cardId")
            val catId = backStack.arguments?.getString("catId")
            if (cardID != null && catId != null) {
                Add_Edit_Card_Screen(navController, catId, cardID)
            }
        }

        composable("individual Card/{catId}/{cardId}", arguments = listOf(
            navArgument("catId") {
               type = NavType.StringType
            },
            navArgument("cardId") {
               type=  NavType.StringType
            }
        )) {backStack->
            val catId = backStack.arguments?.getString("catId")
            val cardID = backStack.arguments?.getString("cardId")
            if (cardID != null && catId != null) {
                IndividualCardScreen(navController, catId, cardID)
            }
        }
        
        
        composable("Cards List/{categId}", arguments = listOf(
            navArgument("categId") {
                type = NavType.StringType
            }
        )) {backStack->
            val catID = backStack.arguments?.getString("categId")
            catID?.let { CardsListScreen(navController, catID) }
        }
    }
}