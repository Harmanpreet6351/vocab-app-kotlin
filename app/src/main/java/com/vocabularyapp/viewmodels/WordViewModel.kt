package com.vocabularyapp.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vocabularyapp.database.VocabDatabase
import com.vocabularyapp.models.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordViewModel @Inject constructor(
    private val vocabDatabase: VocabDatabase
): ViewModel() {

    val vocabList: LiveData<List<Word>>
        get() = vocabDatabase.wordDao().getAll()

    fun addWord(word: Word) {
        viewModelScope.launch {
            vocabDatabase.wordDao().insert(word)
        }
    }

    fun clearDatabase() {
        viewModelScope.launch {
            vocabDatabase.wordDao().clearAll()
        }
    }

    fun deleteWord(word: Word) {
        viewModelScope.launch {
            vocabDatabase.wordDao().delete(word)
        }
    }

    fun updateWord(word: Word) {
        viewModelScope.launch {
            vocabDatabase.wordDao().update(word)
        }
    }

}