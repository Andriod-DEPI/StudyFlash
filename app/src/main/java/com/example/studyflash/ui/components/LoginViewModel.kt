package com.example.studyflash.viewmodels

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import com.google.firebase.auth.FirebaseAuth
import androidx.lifecycle.viewModelScope
import com.example.studyflash.classes.User
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    var loginErrorMessage = mutableStateOf("")
    var loginSuccess = mutableStateOf(false)

    // Updated login function to take User object
    fun login(user: User) {
        viewModelScope.launch {
            // Extract email and password from the User object
            auth.signInWithEmailAndPassword(user.email, user.password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        loginErrorMessage.value = "Login successful!"
                        loginSuccess.value = true
                    } else {
                        loginErrorMessage.value = "Login failed: ${task.exception?.message}"
                        loginSuccess.value = false
                    }
                }
        }
    }
    fun resetLoginSuccess(){
        loginSuccess.value = false
    }
}
