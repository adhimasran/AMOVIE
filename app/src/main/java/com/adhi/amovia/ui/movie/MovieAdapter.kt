package com.adhi.amovia.ui.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adhi.amovia.data.source.local.entity.MovieEntity
import com.adhi.amovia.databinding.ItemsGridBinding
import com.adhi.amovia.utils.Utility.loadImage

class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    private var listMovie = ArrayList<MovieEntity>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setMovie(movie: List<MovieEntity>?) {
        if (movie == null) return
        this.listMovie.clear()
        this.listMovie.addAll(movie)
        notifyDataSetChanged()
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = ItemsGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(movie)
        }
    }

    override fun getItemCount(): Int = listMovie.size

    class MovieViewHolder(private val binding: ItemsGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvTitle.text = movie.title
                tvRating.text = movie.rating.toString()
                imgPoster.loadImage(movie.imgPoster)
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: MovieEntity)
    }
}