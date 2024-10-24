package com.example.studyflash.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.studyflash.R.drawable.signup
import com.example.studyflash.ui.components.SignUpTextField
import com.google.firebase.auth.FirebaseAuth
import androidx.compose.ui.platform.LocalContext

@Composable
fun SignupScreen(navController: NavHostController, onSignInClick: () -> Unit) {
    Surface {
        var username by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }
        val auth = FirebaseAuth.getInstance()
        val context = LocalContext.current

        Column(modifier = Modifier.fillMaxSize()) {
            val uniColor: Color = if (isSystemInDarkTheme()) Color.White else Color.Black

            Box(contentAlignment = Alignment.TopCenter) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = signup),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = 720.dp),
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
                                append("Already have an account ?")
                            }
                        }
                    )
                }

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
                                    fontWeight = FontWeight.Medium
                                )
                            ) {
                                append(" ")
                                append("Sign in")
                            }
                        },
                                modifier = Modifier.clickable { onSignInClick() } // Trigger navigation
                    )
                }

                Column(
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp)
                ) {
                    Text(
                        text = "Sign Up",
                        modifier = Modifier
                            .offset(y = 120.dp, x = -120.dp),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 30.sp,
                    )

                    SignUpTextField(
                        label = "Username",
                        trailing = " ",
                        value = username,
                        onValueChange = { username = it },
                        modifier = Modifier.fillMaxWidth().offset(y = 210.dp)
                    )
                    SignUpTextField(
                        label = "E-Mail",
                        trailing = " ",
                        value = email,
                        onValueChange = { email = it },
                        modifier = Modifier.fillMaxWidth().offset(y = 220.dp)
                    )
                    SignUpTextField(
                        label = "Password",
                        trailing = " ",
                        value = password,
                        onValueChange = { password = it },
                        modifier = Modifier.fillMaxWidth().offset(y = 230.dp)
                    )
                    SignUpTextField(
                        label = "Confirm Password",
                        trailing = " ",
                        value = confirmPassword,
                        onValueChange = { confirmPassword = it },
                        modifier = Modifier.fillMaxWidth().offset(y = 240.dp)
                    )
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 30.dp)
                            .offset(y = 210.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            modifier = Modifier
                                .width(230.dp)
                                .height(80.dp)
                                .padding(12.dp),
                            onClick = {
                                if (password == confirmPassword) {
                                    auth.createUserWithEmailAndPassword(email, password)
                                        .addOnCompleteListener { task ->
                                            if (task.isSuccessful) {
                                                // Sign-up successful
                                                Toast.makeText(context, "Sign-up successful", Toast.LENGTH_SHORT).show()
                                                // Navigate to the next screen or update UI
                                            } else {
                                                // Sign-up failed
                                                Toast.makeText(context, task.exception?.message, Toast.LENGTH_SHORT).show()
                                            }
                                        }
                                } else {
                                    Toast.makeText(context, "Passwords do not match", Toast.LENGTH_SHORT).show()
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFAC81F1),
                                contentColor = Color.White
                            ),
                            shape = RoundedCornerShape(size = 17.dp)
                        ) {
                            Text(text = "Sign Up")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignupScreenPreview() {
    // Create a mock NavHostController
    val navController = rememberNavController()
    SignupScreen(navController = navController, onSignInClick = {})
}
