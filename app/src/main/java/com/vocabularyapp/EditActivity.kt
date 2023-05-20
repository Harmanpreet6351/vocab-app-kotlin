package com.vocabularyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText
import com.vocabularyapp.models.Word
import com.vocabularyapp.viewmodels.WordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditActivity : AppCompatActivity() {

    private lateinit var wordViewModel: WordViewModel

    private val editWordTextView: TextInputEditText
        get() = findViewById(R.id.editWordTextView)

    private val editMeaningText: TextInputEditText
        get() = findViewById(R.id.editMeaningTextView)

    private val editSaveButtonView: Button
        get() = findViewById(R.id.editSaveButtonView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        wordViewModel = ViewModelProvider(this)[WordViewModel::class.java]

        val id = intent.getIntExtra("id", -1)

        if(id != -1) {
            editWordTextView.setText(intent.getStringExtra("word"))
            editMeaningText.setText(intent.getStringExtra("meaning"))
        }

        editSaveButtonView.setOnClickListener {
            if(id == -1) {
                val word = Word(
                    id = 0,
                    word = editWordTextView.text.toString(),
                    meaning = editMeaningText.text.toString()
                )
                wordViewModel.addWord(word)
                finish()
            } else {
                val word = Word(
                    id = id,
                    word = editWordTextView.text.toString(),
                    meaning = editMeaningText.text.toString()
                )
                wordViewModel.updateWord(word)
                finish()
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}