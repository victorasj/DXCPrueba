package com.victorasj.dxcprueba.ui.main

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import basicDiffUtil
import com.victorasj.domain.Photo
import com.victorasj.dxcprueba.R
import com.victorasj.dxcprueba.databinding.PhotoViewBinding
import inflate
import loadUrl

class PhotoAdapter(val listener: (Photo) -> Unit) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    var photos : List<Photo> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.id == new.id }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(parent.inflate(R.layout.photo_view, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)
        holder.itemView.setOnClickListener { listener(photo) }
    }

    override fun getItemCount(): Int = photos.size

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val binding = PhotoViewBinding.bind(view)
        fun bind(photo : Photo) = with(binding){
            textViewTitle.text = photo.title
            textViewAuthor.text = photo.author
            photo.image?.let { imageViewPhoto.loadUrl(it) }
        }
    }
}

