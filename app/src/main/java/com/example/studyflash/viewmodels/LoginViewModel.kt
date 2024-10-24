package com.example.studyflash.viewmodels

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import com.google.firebase.auth.FirebaseAuth
import androidx.lifecycle.viewModelScope
import com.example.studyflash.classes.User
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    var loginErrorMessage = mutableStateOf("")
    var loginSuccess = mutableStateOf(false)
    var userScore = mutableStateOf(0) // To track the score after login

    // Updated login function to take User object
    fun login(user: User) {
        viewModelScope.launch {
            auth.signInWithEmailAndPassword(user.email, user.password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // Login successful, now fetch the score from the database
                        val uid = auth.currentUser?.uid
                        if (uid != null) {
                            // Assuming you're using Firestore or Realtime Database to store user data
                            // Firestore example
                            val firestore = FirebaseFirestore.getInstance()
                            firestore.collection("users").document(uid)
                                .get()
                                .addOnSuccessListener { document ->
                                    if (document.exists()) {
                                        // Retrieve score and update user object
                                        val score = document.getLong("score")?.toInt() ?: 0
                                        userScore.value = score
                                        loginSuccess.value = true
                                        loginErrorMessage.value = "Login successful!"
                                    } else {
                                        loginErrorMessage.value = "User data not found"
                                        loginSuccess.value = false
                                    }
                                }
                                .addOnFailureListener {
                                    loginErrorMessage.value = "Failed to retrieve user data"
                                    loginSuccess.value = false
                                }
                        }
                    } else {
                        loginErrorMessage.value = "Login failed: ${task.exception?.message}"
                        loginSuccess.value = false
                    }
                }
        }
    }

    fun resetLoginSuccess() {
        loginSuccess.value = false
    }
}
