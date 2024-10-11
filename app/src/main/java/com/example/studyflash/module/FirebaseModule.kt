package com.example.studyflash.module

import com.example.studyflash.repositories.CardCategoryRepoImpl
import com.example.studyflash.repositories.CardCategoryRepository
import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {
    @Provides
    @Singleton
    fun provideFirestore():FirebaseFirestore{
        return FirebaseFirestore.getInstance()
    }

    @Provides
    @Singleton
    fun provideRepository(firestore: FirebaseFirestore):CardCategoryRepository{
        return CardCategoryRepoImpl(firestore)
    }
}