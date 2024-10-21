package com.example.studyflash.repositories

import android.util.Log
import com.example.studyflash.classes.Card
import com.example.studyflash.classes.Category
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class CardCategoryRepoImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : CardCategoryRepository {

    override suspend fun getCategories(): List<Category> {
        // Fetch all categories
        val categories =  firestore.collection("Categories")
            .get()
            .await()
            .toObjects(Category::class.java)
        return categories

    }

    override suspend fun getCardsForCategory(categoryId: String): List<Card> {
        // Fetch cards belonging to a specific category
        return firestore.collection("Categories")
            .document(categoryId)
            .collection("Cards")
            .get()
            .await()
            .toObjects(Card::class.java)
    }

    override suspend fun addCategory(category: Category) {
        // Add a new category with Firestore generating the ID automatically
        val newCategoryRef = firestore.collection("Categories")
            .add(category) // Firestore will generate a unique ID
            .await()

        // Update the category ID field with the generated ID
        firestore.collection("Categories")
            .document(newCategoryRef.id) // Get the generated ID
            .update("id", newCategoryRef.id) // Update the category with the generated ID
            .await()
    }

    override suspend fun updateCategory(category: Category) {
        // Update an existing category by its ID
        firestore.collection("Categories")
            .document(category.id) // Use category.id as it should be a String
            .set(category)
            .await()
    }

    override suspend fun deleteCategory(categoryId: String) {
        // Delete a category by its ID
        firestore.collection("Categories")
            .document(categoryId)
            .delete()
            .await()
    }

    override suspend fun addCard(card: Card) {
        // Add a card to a specific category with Firestore generating the ID automatically
        val newCardRef = firestore.collection("Categories")
            .document(card.categoryID) // Assuming card has a categoryID field
            .collection("Cards")
            .add(card) // Firestore will generate a unique ID
            .await()

        // Update the card ID field with the generated ID
        firestore.collection("Categories")
            .document(card.categoryID) // Use categoryID to find the category
            .collection("Cards")
            .document(newCardRef.id) // Get the generated ID
            .update("id", newCardRef.id) // Update the card with the generated ID
            .await()
    }

    override suspend fun updateCard(card: Card) {
        // Update a card in a specific category by its ID
        firestore.collection("Categories")
            .document(card.categoryID) // Use card.categoryID to find the category
            .collection("Cards")
            .document(card.id) // Use card.id as it should be a String
            .set(card)
            .await()
    }

    override suspend fun deleteCard(cardId: String, categoryId: String) {
        // Delete a card from a specific category by its ID
        firestore.collection("Categories")
            .document(categoryId)
            .collection("Cards")
            .document(cardId)
            .delete()
            .await()
    }
}
