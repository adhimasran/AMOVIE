package com.adhi.amovia.ui.movie

import androidx.lifecycle.ViewModel
import com.adhi.amovia.data.Film
import com.adhi.amovia.utils.DataDummy

class MovieViewModel : ViewModel() {
    fun getMovie(): List<Film> = DataDummy.generateDummyMovies()
}