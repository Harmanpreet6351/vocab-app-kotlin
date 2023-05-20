package com.vocabularyapp.di

import android.content.Context
import androidx.room.Room
import com.vocabularyapp.database.VocabDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesVocabDatabase(@ApplicationContext context: Context): VocabDatabase {
        return Room.databaseBuilder(context, VocabDatabase::class.java, "vocabDatabase").build()
    }

}