package com.example.studyflash.ui.screens

import LoginViewModel
import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyflash.R.drawable.background
import com.example.studyflash.R.drawable.profile
import com.example.studyflash.ui.components.LoginTextfield

// UI Function
@Composable
fun LoginScreenContent(
    email: String,
    password: String,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: (String, String) -> Unit,
    loginErrorMessage: String = ""
) {
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
                        .offset(y = 160.dp),
                    painter = painterResource(id = profile),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
                Text(
                    text = "Login",
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
                                append("Don't have account ?")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium
                                )
                            ) {
                                append(" Create new account")
                            }
                        }
                    )
                }

                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxSize().offset(y=430.dp)
                        .padding(horizontal = 30.dp)
                ) {
                    LoginTextfield(
                        label = "Email",
                        trailing = "",
                        value = email,  // Bind email state to TextField
                        onValueChange = { newEmail -> onEmailChange(newEmail) } // Update email state using callback
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    // Password TextField
                    LoginTextfield(
                        label = "Password",
                        trailing = "Forgot?",
                        value = password,  // Bind password state to TextField
                        onValueChange = { newPassword -> onPasswordChange(newPassword) } // Update password state using callback
                    )


                    Spacer(modifier = Modifier.height(20.dp))

                    // Login Button
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 30.dp)
                            .offset(y = 230.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            modifier = Modifier
                                .width(230.dp)
                                .height(80.dp)
                                .padding(12.dp),
                            onClick = { onLoginClick(email, password) },  // Trigger login on button click
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isSystemInDarkTheme()) Color(0xFFAC81F1) else Color(0xFFAC81F1),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(size = 17.dp)
                        ) {
                            Text(text = "Login")
                        }
                    }

                    // Show error message if login fails
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
        onLoginClick = { _, _ -> },
        loginErrorMessage = ""
    )
}

// Use this in the actual screen logic to pass real Firebase login functionality
@Composable
fun Loginscreen(viewModel: LoginViewModel) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val loginErrorMessage = viewModel.loginErrorMessage.value

    LoginScreenContent(
        email = email.value,
        password = password.value,
        onEmailChange = { newEmail -> email.value = newEmail },  // Update email state
        onPasswordChange = { newPassword -> password.value = newPassword },  // Update password state
        onLoginClick = { emailValue, passwordValue ->
            viewModel.login(emailValue, passwordValue)
        },
        loginErrorMessage = loginErrorMessage
    )
}

