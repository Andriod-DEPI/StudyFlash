package com.example.studyflash.ui.components

import android.provider.ContactsContract.CommonDataKinds.Email
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.studyflash.ui.theme.focusedTextFieldText
import com.example.studyflash.ui.theme.textFieldContainer
import com.example.studyflash.ui.theme.unfocusedTextFieldText
import com.google.firebase.auth.FirebaseAuth


@Composable

fun LoginTextfield(
    modifier: Modifier = Modifier,
    label: String,
    trailing: String,
//    email: String,
    value: String,
    onValueChange: (String) -> Unit

){
    val uniColor: Color = if (isSystemInDarkTheme()) Color.White else Color.Black
    val auth = FirebaseAuth.getInstance()
    val passwordVisibility = remember { mutableStateOf(false) }
    val password = remember { mutableStateOf("") }

    TextField(
        modifier = modifier.fillMaxWidth().padding(16.dp),
        value = "",
        onValueChange = {},
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                fontSize = 15.sp,
                color = uniColor
            )
        },

        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),

        colors = TextFieldDefaults.colors(
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
            focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldText,
            unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
            focusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
        ),

        trailingIcon = {
            TextButton(
                onClick = {
                    // Toggle password visibility
                    passwordVisibility.value = !passwordVisibility.value
                }
            ) {
                Text(
                    text = if (passwordVisibility.value) "Hide" else "Show",
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                    color = uniColor
                )
            }
        }
    )

//            TextButton(onClick = {
//                if (trailing == "Forgot?" && email.isNotEmpty()) {
//                    auth.sendPasswordResetEmail(email)
//                        .addOnCompleteListener { task ->
//                            if (task.isSuccessful) {
//                                println("Password reset email sent.")
//                            } else {
//                                println("Failed to send password reset email: ${task.exception?.message}")
//                            }
//                        }
//                }
//            })
//            {
//                Text(
//                    text = trailing,
//                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
//                    color = uniColor
//                )
//
//
//            }
}

