package com.example.studyflash.repositories

import com.example.studyflash.classes.Card
import com.example.studyflash.classes.Category
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class CardCategoryRepoImpl @Inject constructor(private val firestore: FirebaseFirestore):CardCategoryRepository {
    override suspend fun getCategories(): List<Category> {
        return firestore.collection("Categories").get().await().toObjects(Category::class.java)
    }

    override suspend fun getCardsForCategory(categoryId: Int): List<Card> {
       return firestore.collection("Cards").whereEqualTo("CategoryID123", categoryId).get().await().toObjects(Card::class.java)
    }

    override suspend fun addCategory(category: Category) {
        val newCatRef=firestore.collection("Categories").document()
        val newCat = category.copy(id = newCatRef.id.toInt())
        newCatRef.set(newCat).await()
    }

    override suspend fun updateCategory(category: Category) {
        firestore.collection("Categories").document(category.id.toString()).set(category).await()
    }

    override suspend fun deleteCategory(categoryId: Int) {
        firestore.collection("Categories").document(categoryId.toString()).delete().await()
    }

    override suspend fun addCard(card: Card) {
        val newCardRef=firestore.collection("Cards").document()
        val newCard = card.copy(id = newCardRef.id.toInt())
        newCardRef.set(newCard).await()
    }

    override suspend fun updateCard(card: Card) {
        firestore.collection("Cards").document(card.id.toString()).set(card).await()
    }

    override suspend fun deleteCard(cardId: Int) {
        firestore.collection("Cards").document(cardId.toString()).delete().await()
    }


}