package com.example.studyflash.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.studyflash.classes.Card
import com.example.studyflash.classes.Category
import com.example.studyflash.repositories.CardCategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryCardViewModel @Inject constructor(private val repository: CardCategoryRepository):ViewModel() {

    private val _categories = MutableStateFlow<List<Category>> (emptyList())
    val Categories : StateFlow<List<Category>> =_categories.asStateFlow()
    private val _cards = MutableStateFlow<List<Card>> (emptyList())
    val Cards:StateFlow<List<Card>> = _cards.asStateFlow()


    fun loadCategories() = viewModelScope.launch {
        _categories.value = repository.getCategories()
    }

    fun loadCardsForCategory(categryID:Int) = viewModelScope.launch {
        _cards.value = repository.getCardsForCategory(categryID)
    }

    fun addCategory(category: Category)=viewModelScope.launch {
        repository.addCategory(category)
        loadCategories()
    }

    fun updateCategory(category: Category) = viewModelScope.launch {
        repository.updateCategory(category)
        loadCategories()
    }

    fun deleteCategory(categryID: Int)=viewModelScope.launch {
        repository.deleteCategory(categryID)
        loadCategories()
    }

    fun addCard(card: Card)=viewModelScope.launch {
        repository.addCard(card)
        loadCardsForCategory(card.categoryID)
    }

    fun updateCard(card: Card) =viewModelScope.launch {
        repository.updateCard(card)
        loadCardsForCategory(card.categoryID)
    }
    fun deleteCard(cardId:Int, categryID: Int)=viewModelScope.launch {
        repository.deleteCard(cardId)
        loadCardsForCategory(categryID)
    }
}