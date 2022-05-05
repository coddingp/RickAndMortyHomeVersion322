package com.example.rickandmortyhomeversion.main.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rickandmortyhomeversion.R
import com.example.rickandmortyhomeversion.main.models.Result
import timber.log.Timber

class MainAdapter(
    val onClick: (Result) -> Unit
) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private val characters = mutableListOf<com.example.rickandmortyhomeversion.main.models.Result>()


    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.itemImageView)
        private val textView1: TextView = itemView.findViewById(R.id.itemTextView)
        private val textView2: TextView = itemView.findViewById(R.id.itemDescriptionTextView)

        fun bind(result: Result) {
            Glide.with(itemView.context).load(result.image).into(imageView)
            textView1.text = result.name
            textView2.text = result.id.toString()
            itemView.setOnClickListener { onClick.invoke(result) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MainViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val listItem = characters[position]
        holder.bind(listItem)
    }

    override fun getItemCount() = characters.size

    fun setData(list: List<Result>) {
        characters.clear()
        characters.addAll(list)
        Timber.i(list.toString())
        notifyDataSetChanged()
    }


}
