package com.adhi.amovia.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adhi.amovia.data.Film
import com.adhi.amovia.databinding.ItemsListBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class ListAdapter : RecyclerView.Adapter<ListAdapter.FilmViewHolder>() {
    private var listFilm = ArrayList<Film>()
    private var onItemClickCallback: OnItemClickCallback? = null

    fun setFilm(film: List<Film>?) {
        if (film == null) return
        this.listFilm.clear()
        this.listFilm.addAll(film)
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmViewHolder {
        val binding = ItemsListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FilmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FilmViewHolder, position: Int) {
        val film = listFilm[position]
        holder.bind(film)
        holder.itemView.setOnClickListener {
            onItemClickCallback?.onItemClicked(film)
        }
    }

    override fun getItemCount(): Int = listFilm.size

    class FilmViewHolder(private val binding: ItemsListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(film: Film) {
            with(binding) {
                tvTitle.text = film.title
                tvRating.text = film.rating.toString()
                tvRelease.text = film.release

                Glide.with(itemView.context)
                    .load(film.imgPoster)
                    .transform(RoundedCorners(10))
                    .into(imgPoster)
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Film)
    }
}