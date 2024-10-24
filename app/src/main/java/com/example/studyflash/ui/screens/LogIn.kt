package com.example.studyflash.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.studyflash.R
import com.example.studyflash.R.drawable.background
import com.example.studyflash.R.drawable.profile
import com.example.studyflash.classes.User
import com.example.studyflash.ui.components.LoginTextfield
import androidx.compose.ui.platform.LocalContext
import android.app.Activity
import com.example.studyflash.viewmodels.LoginViewModel
import setLocale
import java.util.Locale

// UI Function
@Composable
fun LoginScreenContent(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: (String, String) -> Unit,
    loginErrorMessage: String = "",
    onCreateAccountClick: () -> Unit,
    //Language 
    activity: Activity?
) {
    val context = LocalContext.current
    Surface {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(contentAlignment = Alignment.TopCenter) {

                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = background),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Image(
                    modifier = Modifier
                        .size(100.dp)
                        .offset(y = 135.dp),
                    painter = painterResource(id = profile),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = stringResource(id = R.string.login), // Localized "Login" text
                    modifier = Modifier.offset(y = 320.dp),
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 750.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            ) {
                                append(stringResource(id = R.string.dont_have_account)) // Localized "Don't have an account?"
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            ) {
                                append(stringResource(id = R.string.create_new_account)) // Localized "Create new account"
                            }
                        },
                        modifier = Modifier.clickable { onCreateAccountClick() }
                    )
                }

                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxSize()
                        .offset(y = 430.dp)
                        .padding(horizontal = 30.dp)
                ) {
                    LoginTextfield(
                        label = stringResource(id = R.string.email), // Localized "Email" text
                        value = email,
                        onValueChange = { newEmail -> onEmailChange(newEmail) }
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    LoginTextfield(
                        label = stringResource(id = R.string.password), // Localized "Password" text
                        value = password,
                        onValueChange = { newPassword -> onPasswordChange(newPassword) }
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 30.dp)
                            .offset(y = (-50).dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            modifier = Modifier
                                .width(230.dp)
                                .height(80.dp)
                                .padding(12.dp),
                            onClick = { onLoginClick(email, password) },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isSystemInDarkTheme()) Color(0xFFAC81F1) else Color(0xFFAC81F1),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(size = 17.dp)
                        ) {
                            Text(text = stringResource(id = R.string.login)) // Localized "Login" text
                        }
                        //////////////////////////Language //////////////////////////
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 30.dp)
                                .offset(x = 130.dp,y = (-630).dp),
                            contentAlignment = Alignment.Center
                        ){
                        Button(
                            modifier = Modifier
                                .width(100.dp)
                                .height(80.dp)
                                .padding(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isSystemInDarkTheme()) Color(0xFF6A31F7) else Color(0xFF6A31F7),
                                contentColor = Color.White
                            ),
                            onClick = {
                                val newLanguage = if (Locale.getDefault().language == "ar") "en" else "ar"
                                setLocale(context, newLanguage)

                                activity?.recreate()  

                            }
                        ) {
                            Text(text = stringResource(id = R.string.language_toggle))
                        }}
                    }

                    if (loginErrorMessage.isNotEmpty()) {
                        Text(
                            text = loginErrorMessage,
                            color = Color.Red,
                            modifier = Modifier.padding(top = 20.dp)
                        )
                    }
                }
            }
        }
    }
}
// Preview function for the UI
@Preview(showSystemUi = true)
@Composable
fun LoginscreenPreview() {
    val emailState = remember { mutableStateOf("test@example.com") }
    val passwordState = remember { mutableStateOf("password123") }

    LoginScreenContent(
        email = "test@example.com",
        password = "password123",
        onEmailChange = { newEmail -> emailState.value = newEmail },
        onPasswordChange = { newPassword -> passwordState.value = newPassword },
        onLoginClick = { _, _ -> /* Do nothing in preview */ }, 
        loginErrorMessage = "",
        onCreateAccountClick = {},
        activity = null //Language 
    )
}
// Use this in the actual screen logic to pass real Firebase login functionality
@Composable
fun Loginscreen(
    viewModel: LoginViewModel,
    navController: NavHostController,
    activity: Activity?//Language 
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val loginErrorMessage = viewModel.loginErrorMessage.value
    var loginSuccess = viewModel.loginSuccess.value

    if (loginSuccess) {
        navController.popBackStack()
        navController.navigate("HomePage")
        viewModel.resetLoginSuccess()
    }
    LoginScreenContent(
        email = email.value,
        password = password.value,
        onEmailChange = { newEmail -> email.value = newEmail },  // Update email state
        onPasswordChange = { newPassword -> password.value = newPassword },  // Update password state
        onLoginClick = { emailValue, passwordValue ->
            val user = User(email = emailValue, password = passwordValue, username = null.toString())
            viewModel.login(user)
        },
        loginErrorMessage = loginErrorMessage,
        onCreateAccountClick = {
            navController.navigate("signUp") // Navigate to Signup screen
        },
        activity = activity //Language 
    )}
