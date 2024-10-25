package com.example.studyflash.viewmodels

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.example.studyflash.classes.User
import com.google.firebase.firestore.FieldValue
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val auth: FirebaseAuth,
    private val db: FirebaseFirestore
) : ViewModel() {

    var username = mutableStateOf("")
    var userScore = mutableStateOf(0)
    var userFetchErrorMessage = mutableStateOf("")

    fun updateUserScore(n:Double) {
        val currentUser = auth.currentUser
        currentUser?.let {
            // Increment the user's score by 1
            db.collection("users").document(it.uid)
                .update("score", FieldValue.increment(n))
        }
    }
    // Function to retrieve the current user's username and score
    fun fetchCurrentUserDetails() {
        val currentUser = auth.currentUser
        currentUser?.let {
            val userId = it.uid

            db.collection("users").document(userId).get()
                .addOnSuccessListener { document ->
                    if (document != null && document.exists()) {
                        // Retrieve username and score
                        username.value = document.getString("username") ?: "N/A"
                        userScore.value = document.getLong("score")?.toInt() ?: 0
                    } else {
                        userFetchErrorMessage.value = "No user data found."
                    }
                }
                .addOnFailureListener { e ->
                    userFetchErrorMessage.value = "Error fetching user data: ${e.message}"
                }
        } ?: run {
            userFetchErrorMessage.value = "User not logged in."
        }
    }
}
