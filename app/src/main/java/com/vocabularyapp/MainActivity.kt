package com.vocabularyapp

import android.content.Intent
import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vocabularyapp.adapter.WordAdapter
import com.vocabularyapp.viewmodels.WordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var wordViewModel: WordViewModel

    private val mainAddNewButtonView: Button
        get() = findViewById(R.id.mainAddNewButtonView)

    private val mainWordRecyclerView: RecyclerView
        get() = findViewById(R.id.mainWordRecyclerView)

    private val mainEmptyTextView: TextView
        get() = findViewById(R.id.mainEmptyTextView)

    private lateinit var wordAdapter: WordAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wordViewModel = ViewModelProvider(this)[WordViewModel::class.java]

        mainWordRecyclerView.layoutManager = LinearLayoutManager(this)

        wordAdapter = WordAdapter(wordViewModel)

        mainWordRecyclerView.adapter = wordAdapter

        wordViewModel.vocabList.observe(this, Observer {
            if(it.size == 0) {
                mainEmptyTextView.visibility = View.VISIBLE
            } else {
                mainEmptyTextView.visibility = View.GONE
            }
            wordAdapter.submitList(it)
        })

        mainAddNewButtonView.setOnClickListener{
            val i = Intent(this, EditActivity::class.java)

            startActivity(i)
        }

    }
}