package com.adhi.amovia.ui.detail

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.adhi.amovia.R
import com.adhi.amovia.data.source.local.entity.DetailMovieEntity
import com.adhi.amovia.databinding.ActivityDetailMovieBinding
import com.adhi.amovia.utils.Utility.convertToDate
import com.adhi.amovia.utils.Utility.convertToTime
import com.adhi.amovia.utils.Utility.loadImage
import com.adhi.amovia.viewmodel.ViewModelFactory

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMovieBinding
    private val viewModelFactory = ViewModelFactory.getInstance()
    private val viewModel: DetailMovieViewModel by viewModels { viewModelFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.title = resources.getString(R.string.detail)

        val id = intent.getIntExtra(EXTRA_MOVIE, 0)
        viewModel.getDetailMovie(id).observe(this, {
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

    private fun setDetail(movie: DetailMovieEntity) {
        val year = movie.release.convertToDate().split(", ")[1]

        binding.apply {
            tvTitle.text = resources.getString(R.string.title, movie.title, year)
            tvTagline.text = movie.tagline
            tvRating.text = movie.rating.toString()
            tvRatingCount.text =
                resources.getString(R.string.rating_count, movie.ratingCount.toString())
            tvRelease.text = movie.release.convertToDate()
            tvDuration.text = resources.getString(R.string.duration, movie.runtime.convertToTime())
            tvOverview.text = movie.overview
            imgPoster.loadImage(movie.imgPoster)
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
        const val EXTRA_MOVIE = "extra_movie"
    }
}