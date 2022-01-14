package com.adhi.amovia.ui.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adhi.amovia.data.source.FilmRepository
import com.adhi.amovia.data.source.local.entity.MovieEntity

class MovieViewModel(private val repo: FilmRepository) : ViewModel() {
    fun getMovies(): LiveData<List<MovieEntity>> = repo.getMovies()
}