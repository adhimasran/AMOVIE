package com.adhi.amovia.ui.tv

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adhi.amovia.data.source.FilmRepository
import com.adhi.amovia.data.source.local.entity.TvEntity

class TvShowViewModel(private val repo: FilmRepository) : ViewModel() {
    fun getTvShows(): LiveData<List<TvEntity>> = repo.getTvShows()
}