package com.adhi.amovia.data.source

import androidx.lifecycle.LiveData
import com.adhi.amovia.data.source.local.entity.DetailMovieEntity
import com.adhi.amovia.data.source.local.entity.DetailTvEntity
import com.adhi.amovia.data.source.local.entity.MovieEntity
import com.adhi.amovia.data.source.local.entity.TvEntity

interface FilmDataSource {
    fun getMovies(): LiveData<List<MovieEntity>>

    fun getTvShows(): LiveData<List<TvEntity>>

    fun getDetailMovie(id: Int): LiveData<DetailMovieEntity>

    fun getDetailTv(id: Int): LiveData<DetailTvEntity>
}