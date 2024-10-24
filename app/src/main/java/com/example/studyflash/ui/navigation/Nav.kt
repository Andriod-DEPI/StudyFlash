package com.example.studyflash.ui.navigation

import android.app.Activity
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
import com.example.studyflash.ui.screens.ProfilePage
import com.example.studyflash.ui.screens.QuizScore
import com.example.studyflash.ui.screens.QuizScreen
import com.example.studyflash.ui.screens.SignupScreen


@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    activity: Activity
) {


    NavHost(navController = navController, startDestination = "landPage") {
       composable("login") {
            // Create or retrieve an instance of LoginViewModel
            val loginViewModel: LoginViewModel = viewModel()

            // Pass the NavController to Loginscreen
           Loginscreen(
               viewModel = loginViewModel,
               navController = navController,
               activity = activity
           )

        }
        composable("signUp") {
            SignupScreen(
                navController = navController,
                onSignInClick = { navController.navigate("logIn") })
        }
        composable("HomePage") {
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
        composable("quiz"){
            QuizScreen(navController)
        }
        composable(
            route = "quiz_score_screen/{correctAns}/{totalQuestions}",
            arguments = listOf(
                navArgument("correctAns") {
                    type = NavType.IntType
                },
                navArgument("totalQuestions") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            // Retrieve arguments passed via the route
            val correctAnswers = backStackEntry.arguments?.getInt("correctAns") ?: 0
            val totalQuestions = backStackEntry.arguments?.getInt("totalQuestions") ?: 0

            // Call the QuizScore Composable to display the score
            QuizScore(correctAnswers, totalQuestions, navController)
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
