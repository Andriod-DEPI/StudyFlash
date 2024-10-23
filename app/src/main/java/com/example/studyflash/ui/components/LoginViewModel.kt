package com.example.studyflash.viewmodels

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import com.google.firebase.auth.FirebaseAuth
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    var loginErrorMessage = mutableStateOf("")
    var loginSuccess = mutableStateOf(false)
    
    fun login(email: String, password: String) {
        viewModelScope.launch {
            auth.signInWithEmailAndPassword(email, password)
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
}
