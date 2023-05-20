package com.vocabularyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private val detailWordTextView: TextView
        get() = findViewById(R.id.detailWordTextView)

    private val detailMeaningTextView: TextView
        get() = findViewById(R.id.detailMeaningTextView)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        detailWordTextView.text = intent.getStringExtra("word")
        detailMeaningTextView.text = intent.getStringExtra("meaning")

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}