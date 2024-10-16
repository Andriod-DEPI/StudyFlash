package com.example.studyflash.ui.screens

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.studyflash.R.drawable.signup
import com.example.studyflash.R.drawable.user
import com.example.studyflash.ui.components.SignUpTextField

@Preview (showSystemUi = true)
@Composable
fun SignupScreen() {
    Surface {

        Column(modifier = Modifier.fillMaxSize())
        {
            val uniColor: Color = if (isSystemInDarkTheme()) Color.White else Color.Black

            Box(
                contentAlignment = Alignment.TopCenter
            ) {
                Image(
                    modifier = Modifier.fillMaxSize(),
                    painter = painterResource(id = signup),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y=720.dp),
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
                                append("Already have an account ?")
                            }
                        }
                    )
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y=750.dp),
                    contentAlignment = Alignment.Center
                ){
                    Text(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Black,
                                    fontSize = 14.sp,
//                            fontFamily = Roboto,
                                    fontWeight = FontWeight.Medium
                                )
                            ) {
                                append(" ")
                                append("Sign in")
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
                    Text(
                        text = "Sign Up",
                        modifier = Modifier
                            .offset(y = 120.dp, x = -120.dp),
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 30.sp,

                        )

                    SignUpTextField(
                        label = "UserName",
                        trailing = " ",
                        modifier = Modifier.fillMaxWidth().offset(y = 210.dp),


                    )
                    SignUpTextField(
                        label = "E-Mail",
                        trailing = " ",
                        modifier = Modifier.fillMaxWidth().offset(y = 220.dp),

                    )
                    SignUpTextField(
                        label = "Password",
                        trailing = " ",
                        modifier = Modifier.fillMaxWidth().offset(y = 230.dp),

                    )
                    Spacer(modifier = Modifier.width(15.dp))
                    SignUpTextField(
                        label = "Confirm Password",
                        trailing = " ",
                        modifier = Modifier.fillMaxWidth().offset(y = 230.dp),

                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 30.dp).offset(y = 210.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(
                            modifier = Modifier
                                .width(230.dp)
                                .height(80.dp)
                                .padding(12.dp),

                            onClick = {/*TODO*/ },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (isSystemInDarkTheme()) Color(0xFFAC81F1) else Color(
                                    0xFFAC81F1
                                ),
                                contentColor = androidx.compose.ui.graphics.Color.White
                            ),
                            shape = RoundedCornerShape(size = 17.dp)
                        ) {
                            Text(text = "Sign Up")
                        }
                    }
                }




            }
        }

    }}