package com.adhi.amovia.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.adhi.amovia.data.Film
import com.adhi.amovia.utils.DataDummy

class DetailViewModel : ViewModel() {
    private val _film = MutableLiveData<Film>()
    val film: LiveData<Film> get() = _film

    private val _films = DataDummy.generateDummyMovies().plus(DataDummy.generateDummyTvShow())
    val films get() = _films

    fun setDetailFilm(id: String) {
        _film.postValue(_films.find { it.id == id })
    }
}