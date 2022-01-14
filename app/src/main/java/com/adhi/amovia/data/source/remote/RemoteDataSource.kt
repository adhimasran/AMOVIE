package com.adhi.amovia.data.source.remote

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.adhi.amovia.data.api.ApiConfig
import com.adhi.amovia.data.source.remote.response.*
import com.adhi.amovia.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    private val handler = Handler(Looper.getMainLooper())
    private val apiConfig = ApiConfig.getApiService()

    fun getMovies(callback: GetMoviesCallback): LiveData<List<MovieResponse>> {
        val listMovie = MutableLiveData<List<MovieResponse>>()
        val client = apiConfig.getPopularMovies()
        EspressoIdlingResource.increment()
        handler.postDelayed({
            client.enqueue(object : Callback<ListMovie> {
                override fun onResponse(
                    call: Call<ListMovie>,
                    response: Response<ListMovie>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.results?.let { callback.onResponse(it) }
                        EspressoIdlingResource.decrement()
                    } else {
                        Log.e("Movie", "onFailure: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<ListMovie>, t: Throwable) {
                    Log.e("Movie", "onFailure: ${t.message.toString()}")
                }
            })
        }, 1000)

        return listMovie
    }

    fun getDetailMovie(id: Int, callback: GetDetailMovieCallback) {
        val client = apiConfig.getDetailMovie(id)
        EspressoIdlingResource.increment()
        handler.postDelayed({
            client.enqueue(object : Callback<DetailMovieResponse> {
                override fun onResponse(
                    call: Call<DetailMovieResponse>,
                    response: Response<DetailMovieResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { callback.onResponse(it) }
                        EspressoIdlingResource.decrement()
                    } else {
                        Log.e("Detail Movie", "onFailure: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<DetailMovieResponse>, t: Throwable) {
                    Log.e("Detail Movie", "onFailure: ${t.message.toString()}")
                }
            })
        }, 1000)
    }

    fun getTvShows(callback: GetTvShowsCallback) {
        val client = apiConfig.getPopularTv()
        EspressoIdlingResource.increment()
        handler.postDelayed({
            client.enqueue(object : Callback<ListTv> {
                override fun onResponse(
                    call: Call<ListTv>,
                    response: Response<ListTv>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.results?.let { callback.onResponse(it) }
                        EspressoIdlingResource.decrement()
                    } else {
                        Log.e("TV Shows", "onFailure: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<ListTv>, t: Throwable) {
                    Log.e("TV Shows", "onFailure: ${t.message.toString()}")
                }
            })
        }, 1000)
    }

    fun getDetailTv(id: Int, callback: GetDetailTvCallback) {
        val client = apiConfig.getDetailTv(id)
        EspressoIdlingResource.increment()
        handler.postDelayed({
            client.enqueue(object : Callback<DetailTvResponse> {
                override fun onResponse(
                    call: Call<DetailTvResponse>,
                    response: Response<DetailTvResponse>
                ) {
                    if (response.isSuccessful) {
                        response.body()?.let { callback.onResponse(it) }
                        EspressoIdlingResource.decrement()
                    } else {
                        Log.e("Detail TV Show", "onFailure: ${response.message()}")
                    }
                }

                override fun onFailure(call: Call<DetailTvResponse>, t: Throwable) {
                    Log.e("Detail Tv Show", "onFailure: ${t.message.toString()}")
                }
            })
        }, 1000)
    }

    interface GetMoviesCallback {
        fun onResponse(movieResponse: List<MovieResponse>)
    }

    interface GetDetailMovieCallback {
        fun onResponse(detailMovieResponse: DetailMovieResponse)
    }

    interface GetTvShowsCallback {
        fun onResponse(tvResponse: List<TvResponse>)
    }

    interface GetDetailTvCallback {
        fun onResponse(detailTvResponse: DetailTvResponse)
    }

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }
}