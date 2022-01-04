package com.adhi.amovia.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.adhi.amovia.R
import com.adhi.amovia.data.Film
import com.adhi.amovia.databinding.ActivityDetailBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.title = resources.getString(R.string.detail)

        val filmId = intent.getStringExtra(EXTRA_FILM)

        if (filmId != null) {
            viewModel.setDetailFilm(filmId)
            viewModel.film.observe(this, {
                setDetail(it)
            })
        }
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

    private fun setDetail(film: Film) {
        val duration = "Duration: ${film.duration}"

        binding.apply {
            tvTitle.text = film.title
            tvRating.text = film.rating.toString()
            tvRelease.text = film.release
            tvDuration.text = duration
            tvOverview.text = film.overview

            Glide.with(this@DetailActivity)
                .load(film.imgPoster)
                .transform(RoundedCorners(20))
                .into(imgPoster)
        }
    }

    companion object {
        const val EXTRA_FILM = "extra_film"
    }
}