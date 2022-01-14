package com.adhi.amovia.ui.tv

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adhi.amovia.data.source.local.entity.TvEntity
import com.adhi.amovia.databinding.ItemsGridBinding
import com.adhi.amovia.utils.Utility.loadImage

class TvAdapter : RecyclerView.Adapter<TvAdapter.TvViewHolder>() {
    private var listTv = ArrayList<TvEntity>()
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setTv(tv: List<TvEntity>?) {
        if (tv == null) return
        this.listTv.clear()
        this.listTv.addAll(tv)
        notifyDataSetChanged()
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val binding = ItemsGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        val tv = listTv[position]
        holder.bind(tv)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(tv)
        }
    }

    override fun getItemCount(): Int = listTv.size

    class TvViewHolder(private val binding: ItemsGridBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tv: TvEntity) {
            with(binding) {
                tvTitle.text = tv.name
                tvRating.text = tv.rating.toString()
                imgPoster.loadImage(tv.imgPoster)
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: TvEntity)
    }
}