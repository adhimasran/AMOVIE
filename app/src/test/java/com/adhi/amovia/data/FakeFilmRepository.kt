package com.adhi.amovia.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adhi.amovia.data.source.FilmDataSource
import com.adhi.amovia.data.source.local.entity.DetailMovieEntity
import com.adhi.amovia.data.source.local.entity.DetailTvEntity
import com.adhi.amovia.data.source.local.entity.MovieEntity
import com.adhi.amovia.data.source.local.entity.TvEntity
import com.adhi.amovia.data.source.remote.RemoteDataSource
import com.adhi.amovia.data.source.remote.response.DetailMovieResponse
import com.adhi.amovia.data.source.remote.response.DetailTvResponse
import com.adhi.amovia.data.source.remote.response.MovieResponse
import com.adhi.amovia.data.source.remote.response.TvResponse

class FakeFilmRepository constructor(private val remoteDataSource: RemoteDataSource) :
    FilmDataSource {
    override fun getMovies(): LiveData<List<MovieEntity>> {
        val movies = MutableLiveData<List<MovieEntity>>()
        remoteDataSource.getMovies(object : RemoteDataSource.GetMoviesCallback {
            override fun onResponse(movieResponse: List<MovieResponse>) {
                val listMovie = ArrayList<MovieEntity>()
                for (response in movieResponse) {
                    val movie = MovieEntity(
                        response.id,
                        response.imgPoster,
                        response.title,
                        response.rating
                    )
                    listMovie.add(movie)
                }
                movies.postValue(listMovie)
            }
        })

        return movies
    }

    override fun getTvShows(): LiveData<List<TvEntity>> {
        val tvShows = MutableLiveData<List<TvEntity>>()
        remoteDataSource.getTvShows(object : RemoteDataSource.GetTvShowsCallback {
            override fun onResponse(tvResponse: List<TvResponse>) {
                val listTv = ArrayList<TvEntity>()
                for (response in tvResponse) {
                    val tv = TvEntity(
                        response.id,
                        response.imgPoster,
                        response.name,
                        response.rating
                    )
                    listTv.add(tv)
                }
                tvShows.postValue(listTv)
            }
        })

        return tvShows
    }

    override fun getDetailMovie(id: Int): LiveData<DetailMovieEntity> {
        val movie = MutableLiveData<DetailMovieEntity>()
        remoteDataSource.getDetailMovie(id, object : RemoteDataSource.GetDetailMovieCallback {
            override fun onResponse(detailMovieResponse: DetailMovieResponse) {
                val data = DetailMovieEntity(
                    detailMovieResponse.id,
                    detailMovieResponse.imgPoster,
                    detailMovieResponse.title,
                    detailMovieResponse.tagline,
                    detailMovieResponse.rating,
                    detailMovieResponse.ratingCount,
                    detailMovieResponse.release,
                    detailMovieResponse.runtime,
                    detailMovieResponse.overview
                )
                movie.postValue(data)
            }
        })

        return movie
    }

    override fun getDetailTv(id: Int): LiveData<DetailTvEntity> {
        val tv = MutableLiveData<DetailTvEntity>()
        remoteDataSource.getDetailTv(id, object : RemoteDataSource.GetDetailTvCallback {
            override fun onResponse(detailTvResponse: DetailTvResponse) {
                val runtime =
                    if (detailTvResponse.runtime.isNotEmpty()) detailTvResponse.runtime.first() else 0
                val data = DetailTvEntity(
                    detailTvResponse.id,
                    detailTvResponse.imgPoster,
                    detailTvResponse.name,
                    detailTvResponse.tagline,
                    detailTvResponse.rating,
                    detailTvResponse.ratingCount,
                    detailTvResponse.firstAir,
                    runtime,
                    detailTvResponse.overview
                )
                tv.postValue(data)
            }
        })

        return tv
    }
}