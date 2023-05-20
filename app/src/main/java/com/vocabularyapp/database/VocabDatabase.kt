package com.vocabularyapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vocabularyapp.models.Word

@Database(entities = [Word::class], version = 1)
abstract class VocabDatabase: RoomDatabase() {

    abstract fun wordDao(): WordDao

}