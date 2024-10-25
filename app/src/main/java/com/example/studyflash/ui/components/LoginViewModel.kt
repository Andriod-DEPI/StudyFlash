package com.example.studyflash.viewmodels

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.example.studyflash.classes.User
import com.google.firebase.firestore.FieldValue

class LoginViewModel : ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    var loginErrorMessage = mutableStateOf("")
    var loginSuccess = mutableStateOf(false)

    // Updated login function to take User object
    fun login(user: User) {
        auth.signInWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // After a successful login, store the username in Firestore
                    storeUsername(user.username)
                    loginErrorMessage.value = "Login successful!"
                    loginSuccess.value = true
                } else {
                    // Generalize the error message
                    loginErrorMessage.value = "Login failed. Please check your credentials."
                    loginSuccess.value = false
                }
            }
    }

    private fun storeUsername(username: String) {
        val currentUser = auth.currentUser
        currentUser?.let {
            // Create a map to store user data
            val userMap = hashMapOf(
                "username" to username,
                "email" to it.email,
                "score" to 0 // Example field for user score
            )

            // Store username and other data in Firestore
            db.collection("Users").document(it.uid)
                .set(userMap)
                .addOnSuccessListener {
                    // Optionally handle success (e.g., log or notify)
                }
                .addOnFailureListener { e ->
                    // Handle failure (optional)
                    loginErrorMessage.value = "Failed to store username: ${e.message}"
                }
        }
    }




    // Function to reset login success state
    fun resetLoginSuccess() {
        loginSuccess.value = false
    }
}
