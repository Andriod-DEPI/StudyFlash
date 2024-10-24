package com.example.studyflash.classes

data class User(
    val id: String? = null,
    val username: String?,
    val email: String,
    val password: String,
    var score: Int = 0
)