package com.adhi.amovia.ui.tvshow

import androidx.lifecycle.ViewModel
import com.adhi.amovia.data.Film
import com.adhi.amovia.utils.DataDummy

class TvShowViewModel : ViewModel() {
    fun getTvShow(): List<Film> = DataDummy.generateDummyTvShow()
}