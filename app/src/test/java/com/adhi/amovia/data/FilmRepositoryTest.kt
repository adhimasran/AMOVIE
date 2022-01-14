package com.adhi.amovia.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.adhi.amovia.data.source.remote.RemoteDataSource
import com.adhi.amovia.utils.DataDummy
import com.adhi.amovia.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

class FilmRepositoryTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val filmRepository = FakeFilmRepository(remote)

    private val movies = DataDummy.dummyRemoteMovies()
    private val movie = DataDummy.dummyRemoteMovie()
    private val movieId = movie.id
    private val tvShows = DataDummy.dummyRemoteTvShows()
    private val tv = DataDummy.dummyRemoteTv()
    private val tvId = tv.id

    @Test
    fun getMovies() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.GetMoviesCallback)
                .onResponse(movies)
            null
        }.`when`(remote).getMovies(any())

        val movieEntities = LiveDataTestUtil.getValue(filmRepository.getMovies())
        verify(remote).getMovies(any())
        assertNotNull(movieEntities)
        assertEquals(movies.size.toLong(), movieEntities.size.toLong())
    }

    @Test
    fun getMovie() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.GetDetailMovieCallback)
                .onResponse(movie)
            null
        }.`when`(remote).getDetailMovie(eq(movieId), any())

        val movieEntity = LiveDataTestUtil.getValue(filmRepository.getDetailMovie(movieId))
        verify(remote).getDetailMovie(eq(movieId), any())
        assertNotNull(movieEntity)
        assertEquals(movie.id, movieEntity.id)
    }

    @Test
    fun getTvShows() {
        doAnswer { invocation ->
            (invocation.arguments[0] as RemoteDataSource.GetTvShowsCallback)
                .onResponse(tvShows)
            null
        }.`when`(remote).getTvShows(any())

        val tvEntities = LiveDataTestUtil.getValue(filmRepository.getTvShows())
        verify(remote).getTvShows(any())
        assertNotNull(tvEntities)
        assertEquals(tvShows.size.toLong(), tvEntities.size.toLong())
    }

    @Test
    fun getTv() {
        doAnswer { invocation ->
            (invocation.arguments[1] as RemoteDataSource.GetDetailTvCallback)
                .onResponse(tv)
            null
        }.`when`(remote).getDetailTv(eq(tvId), any())

        val tvEntity = LiveDataTestUtil.getValue(filmRepository.getDetailTv(tvId))
        verify(remote).getDetailTv(eq(tvId), any())
        assertNotNull(tvEntity)
        assertEquals(tv.id, tvEntity.id)
    }
}