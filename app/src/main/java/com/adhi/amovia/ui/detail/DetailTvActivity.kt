package com.adhi.amovia.ui.detail

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.adhi.amovia.R
import com.adhi.amovia.data.source.local.entity.DetailTvEntity
import com.adhi.amovia.databinding.ActivityDetailTvBinding
import com.adhi.amovia.utils.Utility.convertToDate
import com.adhi.amovia.utils.Utility.convertToTime
import com.adhi.amovia.utils.Utility.loadImage
import com.adhi.amovia.viewmodel.ViewModelFactory

class DetailTvActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailTvBinding
    private val viewModelFactory = ViewModelFactory.getInstance()
    private val viewModel: DetailTvViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.title = resources.getString(R.string.detail)

        val id = intent.getIntExtra(EXTRA_TV, 0)
        viewModel.getDetailTv(id).observe(this, {
            if (it != null) {
                setShimmer(false)
                setDetail(it)
            }
        })

        setShimmer(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun setDetail(tv: DetailTvEntity) {
        val year = tv.firstAir.convertToDate().split(", ")[1]

        binding.apply {
            tvTitle.text = resources.getString(R.string.title, tv.name, year)
            tvTagline.text = tv.tagline
            tvRating.text = tv.rating.toString()
            tvRatingCount.text =
                resources.getString(R.string.rating_count, tv.ratingCount.toString())
            tvRelease.text = tv.firstAir.convertToDate()
            tvDuration.text = resources.getString(R.string.duration, tv.runtime.convertToTime())
            tvOverview.text = tv.overview
            imgPoster.loadImage(tv.imgPoster)
        }
    }

    private fun setShimmer(state: Boolean) {
        if (state) {
            binding.shimmer.visibility = View.VISIBLE
            binding.tvRating.visibility = View.GONE
            binding.tvTitleOverview.visibility = View.GONE
        } else {
            binding.shimmer.visibility = View.GONE
            binding.tvRating.visibility = View.VISIBLE
            binding.tvTitleOverview.visibility = View.VISIBLE
        }
    }

    companion object {
        const val EXTRA_TV = "extra_tv"
    }
}