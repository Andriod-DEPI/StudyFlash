package com.example.studyflash.repositories

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
        return firestore.collection("Categories")
            .get()
            .await()
            .toObjects(Category::class.java)
    }

    override suspend fun getCardsForCategory(categoryId: Int): List<Card> {
        // Fetch cards belonging to a specific category
        return firestore.collection("Categories")
            .document(categoryId.toString())
            .collection("Cards")
            .get()
            .await()
            .toObjects(Card::class.java)
    }

    override suspend fun addCategory(category: Category) {
        // Add a new category
        firestore.collection("Categories")
            .document(category.id.toString())
            .set(category)
            .await()
    }

    override suspend fun updateCategory(category: Category) {
        // Update an existing category
        firestore.collection("Categories")
            .document(category.id.toString())
            .set(category)
            .await()
    }

    override suspend fun deleteCategory(categoryId: Int) {
        // Delete a category
        firestore.collection("Categories")
            .document(categoryId.toString())
            .delete()
            .await()
    }

    override suspend fun addCard(card: Card) {
        // Add a card to a specific category
        firestore.collection("Categories")
            .document(card.categoryID.toString()) // Assuming card has a categoryId field
            .collection("Cards")
            .document(card.id.toString())
            .set(card)
            .await()
    }

    override suspend fun updateCard(card: Card) {
        // Update a card in a specific category
        firestore.collection("Categories")
            .document(card.categoryID.toString()) // Assuming card has a categoryId field
            .collection("Cards")
            .document(card.id.toString())
            .set(card)
            .await()
    }

    override suspend fun deleteCard(cardId: Int, categoryId: Int) {
        // Delete a card from a specific category
        firestore.collection("Categories")
            .document(categoryId.toString())
            .collection("Cards")
            .document(cardId.toString())
            .delete()
            .await()
    }
}
