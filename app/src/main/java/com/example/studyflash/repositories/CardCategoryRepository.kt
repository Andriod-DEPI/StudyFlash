package com.example.studyflash.repositories

import com.example.studyflash.classes.Card
import com.example.studyflash.classes.Category

interface CardCategoryRepository {
    // instance of firebase database
    // suspend fun fetchCards():ListOf<Card>{}
    //suspend fun addCard(card:Card, catId){}
    // suspend fun editCard(cardId:Int, card:Card){}
    // suspend fum deleteCard(catId:Int){}

    suspend fun getCategories():List<Category>
    suspend fun getCardsForCategory(categoryId:Int):List<Card>
    suspend fun addCategory(category: Category)
    suspend fun updateCategory(category: Category)
    suspend fun deleteCategory(categoryId: Int)
    suspend fun addCard(card: Card)
    suspend fun updateCard(card: Card)
    suspend fun deleteCard(cardId: Int, categoryId: Int)
}