package com.example.studyflash.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.runtime.*
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
import androidx.compose.runtime.getValue
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
import com.google.firebase.auth.FirebaseAuth

@Preview (showSystemUi = true)
@Composable
fun Loginscreen() {
    Surface {
        val uniColor: Color = if (isSystemInDarkTheme()) Color.White else Color.Black
        val auth = FirebaseAuth.getInstance()

        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var loginErrorMessage by remember { mutableStateOf("") }

        Column(modifier = Modifier.fillMaxSize())
        {

            Box(
                contentAlignment = Alignment.TopCenter
                ) {
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
                    modifier = Modifier
                        .offset(y = 320.dp),
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center,
                    fontSize = 50.sp,

                    )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y=750.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 14.sp,
//                            fontFamily = Roboto,
                                    fontWeight = FontWeight.Normal
                                )
                            ) {
                                append("Don't have account ?")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 14.sp,
//                            fontFamily = Roboto,
                                    fontWeight = FontWeight.Medium
                                )
                            ) {
                                append(" ")
                                append("Create new account")
                            }
                        }
                    )


                }
                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {

                    LoginTextfield(
                        label = "UserName",
                        trailing = " ",
                        modifier = Modifier.fillMaxWidth().offset(y = 420.dp),
                        value = email,
                        onValueChange = { email = it }
                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    LoginTextfield(
                        label = "Password",
                        trailing = "Show",
                        modifier = Modifier.fillMaxWidth().offset(y = 430.dp),
                        value = password,
                        onValueChange = { password = it }
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 30.dp).offset(y = 430.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            modifier = Modifier
                                .width(230.dp)
                                .height(80.dp)
                                .padding(12.dp),

                            onClick = {

                                auth.signInWithEmailAndPassword(email, password)
                                    .addOnCompleteListener { task ->
                                        if (task.isSuccessful) {
                                            loginErrorMessage = "Login successful!"
                                            println("Login successful!")
                                        } else {
                                            loginErrorMessage = "Login failed: ${task.exception?.message}"
                                            println("Login failed: ${task.exception?.message}")
                                        }
                                    }

                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isSystemInDarkTheme()) Color(0xFFAC81F1) else Color(
                                    0xFFAC81F1
                                ),
                                contentColor = androidx.compose.ui.graphics.Color.White
                            ),
                            shape = RoundedCornerShape(size = 17.dp)
                        ) {
                            Text(text = "Login")
                        }
                    }
            }




            }
        }

    }}