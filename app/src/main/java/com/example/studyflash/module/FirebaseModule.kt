package com.example.studyflash.module

import com.example.studyflash.repositories.CardCategoryRepoImpl
import com.example.studyflash.repositories.CardCategoryRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
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
    fun provideFirestore(): FirebaseFirestore {
        return Firebase.firestore
    }

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance() // Providing FirebaseAuth instance
    }

    @Provides
    @Singleton
    fun provideRepository(
        firestore: FirebaseFirestore,
        firebaseAuth: FirebaseAuth // Injecting FirebaseAuth into the repository
    ): CardCategoryRepository {
        return CardCategoryRepoImpl(firestore, firebaseAuth)
    }
}
