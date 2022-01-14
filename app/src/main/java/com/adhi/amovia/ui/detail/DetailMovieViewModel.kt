package com.adhi.amovia.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adhi.amovia.data.source.FilmRepository
import com.adhi.amovia.data.source.local.entity.DetailMovieEntity

class DetailMovieViewModel(private val repo: FilmRepository) : ViewModel() {
    fun getDetailMovie(id: Int): LiveData<DetailMovieEntity> = repo.getDetailMovie(id)
}