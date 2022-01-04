package com.adhi.amovia.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.adhi.amovia.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailViewModelTest {
    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.id
    private val dummyShow = DataDummy.generateDummyTvShow()[0]
    private val showId = dummyShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
    }

    @Test
    fun getCombinedData() {
        assertEquals(20, viewModel.films.size)
    }

    @Test
    fun getCorrectMovie() {
        viewModel.setDetailFilm(movieId)
        assertNotNull(viewModel.film)
        assertEquals(dummyMovie, viewModel.film.value)
    }

    @Test
    fun getCorrectTvShow() {
        viewModel.setDetailFilm(showId)
        assertNotNull(viewModel.film)
        assertEquals(dummyShow, viewModel.film.value)

    }

    @Test
    fun getDetailWithWrongId() {
        viewModel.setDetailFilm("1")
        assertNotEquals(dummyShow, viewModel.film.value)
    }
}