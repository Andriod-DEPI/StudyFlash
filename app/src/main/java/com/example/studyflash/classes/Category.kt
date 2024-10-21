package com.example.studyflash.classes

data class Category(
    val id: String,
    val name: String,
    val colorID: Int,
    var progress: Int
){
    // No-argument constructor for Firestore
    constructor() : this("0", "", 0, 0)
}
