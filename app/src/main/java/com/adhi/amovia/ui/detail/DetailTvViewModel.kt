package com.adhi.amovia.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.adhi.amovia.data.source.FilmRepository
import com.adhi.amovia.data.source.local.entity.DetailTvEntity

class DetailTvViewModel(private val repo: FilmRepository) : ViewModel() {
    fun getDetailTv(id: Int): LiveData<DetailTvEntity> = repo.getDetailTv(id)
}