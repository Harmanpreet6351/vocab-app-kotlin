package com.vocabularyapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.vocabularyapp.models.Word

@Dao
interface WordDao {

    @Insert
    suspend fun insert(word: Word)

    @Update
    suspend fun update(word: Word)

    @Delete
    suspend fun delete(word: Word)

    @Query("SELECT * FROM words")
    fun getAll(): LiveData<List<Word>>

    @Query("DELETE FROM words")
    suspend fun clearAll()

}