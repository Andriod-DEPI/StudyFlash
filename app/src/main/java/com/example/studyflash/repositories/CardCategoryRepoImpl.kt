package com.example.studyflash.repositories

import android.util.Log
import com.example.studyflash.classes.Card
import com.example.studyflash.classes.Category
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject




class CardCategoryRepoImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth // Inject FirebaseAuth to get current user
) : CardCategoryRepository {

    // Helper function to get the current user's UID
    private fun getCurrentUserUid(): String? {
        return auth.currentUser?.uid
    }

    override suspend fun getCategories(): List<Category> {
        // Get categories that belong to the signed-in user
        val uid = getCurrentUserUid()
        return if (uid != null) {
            firestore.collection("Users")
                .document(uid)
                .collection("Categories")
                .get()
                .await()
                .toObjects(Category::class.java)
        } else {
            emptyList() // Return empty list if no user is signed in
        }
    }

    override suspend fun getCardsForCategory(categoryId: String): List<Card> {
        // Fetch cards for a specific category, ensuring it belongs to the signed-in user
        val uid = getCurrentUserUid()
        return if (uid != null) {
            firestore.collection("Users")
                .document(uid)
                .collection("Categories")
                .document(categoryId)
                .collection("Cards")
                .get()
                .await()
                .toObjects(Card::class.java)
        } else {
            emptyList() // Return empty list if no user is signed in
        }
    }

    override suspend fun addCategory(category: Category) {
        // Add a new category under the signed-in user's document
        val uid = getCurrentUserUid()
        if (uid != null) {
            val newCategoryRef = firestore.collection("Users")
                .document(uid)
                .collection("Categories")
                .add(category) // Firestore generates a unique ID
                .await()

            // Update the category's ID field with the generated ID
            firestore.collection("Users")
                .document(uid)
                .collection("Categories")
                .document(newCategoryRef.id)
                .update("id", newCategoryRef.id)
                .await()
        }
    }

    override suspend fun updateCategory(category: Category) {
        // Update an existing category under the signed-in user's document
        val uid = getCurrentUserUid()
        if (uid != null) {
            firestore.collection("Users")
                .document(uid)
                .collection("Categories")
                .document(category.id)
                .set(category)
                .await()
        }
    }

    override suspend fun deleteCategory(categoryId: String) {
        // Delete a category under the signed-in user's document
        val uid = getCurrentUserUid()
        if (uid != null) {
            firestore.collection("Users")
                .document(uid)
                .collection("Categories")
                .document(categoryId)
                .delete()
                .await()
        }
    }

    override suspend fun addCard(card: Card) {
        // Add a card to a specific category under the signed-in user's document
        val uid = getCurrentUserUid()
        if (uid != null) {
            val newCardRef = firestore.collection("Users")
                .document(uid)
                .collection("Categories")
                .document(card.categoryID)
                .collection("Cards")
                .add(card) // Firestore generates a unique ID
                .await()

            // Update the card's ID field with the generated ID
            firestore.collection("Users")
                .document(uid)
                .collection("Categories")
                .document(card.categoryID)
                .collection("Cards")
                .document(newCardRef.id)
                .update("id", newCardRef.id)
                .await()
        }
    }

    override suspend fun updateCard(card: Card) {
        // Update a card in a specific category under the signed-in user's document
        val uid = getCurrentUserUid()
        if (uid != null) {
            firestore.collection("Users")
                .document(uid)
                .collection("Categories")
                .document(card.categoryID)
                .collection("Cards")
                .document(card.id)
                .set(card)
                .await()
        }
    }

    override suspend fun deleteCard(cardId: String, categoryId: String) {
        // Delete a card from a specific category under the signed-in user's document
        val uid = getCurrentUserUid()
        if (uid != null) {
            firestore.collection("Users")
                .document(uid)
                .collection("Categories")
                .document(categoryId)
                .collection("Cards")
                .document(cardId)
                .delete()
                .await()
        }
    }
}
