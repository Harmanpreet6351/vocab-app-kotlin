package com.vocabularyapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vocabularyapp.DetailActivity
import com.vocabularyapp.EditActivity
import com.vocabularyapp.R
import com.vocabularyapp.models.Word
import com.vocabularyapp.viewmodels.WordViewModel

class WordAdapter(val wordViewModel: WordViewModel): ListAdapter<Word, WordAdapter.ViewHolder>(WordAdapter.DiffUtil()) {

    class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
        val listWordTextView = view.findViewById<TextView>(R.id.listWordTextView)
        val listMeaningTextView = view.findViewById<TextView>(R.id.listMeaningTextView)
        val listDeleteButtonView = view.findViewById<Button>(R.id.listDeleteButton)
        val listEditButtonView = view.findViewById<Button>(R.id.listEditButtonView)
    }

    class DiffUtil: androidx.recyclerview.widget.DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.word_recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.listWordTextView.text = item.word
        holder.listMeaningTextView.text = item.meaning
        holder.listDeleteButtonView.setOnClickListener {
            wordViewModel.deleteWord(item)
        }
        holder.listEditButtonView.setOnClickListener {
            val i = Intent(it.context, EditActivity::class.java).apply {
                putExtra("id", item.id)
                putExtra("word", item.word)
                putExtra("meaning", item.meaning)
            }
            it.context.startActivity(i)
        }

        holder.view.setOnClickListener {
            val i = Intent(it.context, DetailActivity::class.java).apply {
                putExtra("word", item.word)
                putExtra("meaning", item.meaning)
            }
            it.context.startActivity(i)
        }
    }

}