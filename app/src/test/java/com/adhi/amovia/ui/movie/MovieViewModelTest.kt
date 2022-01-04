package com.adhi.amovia.ui.movie

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class MovieViewModelTest {
    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovie() {
        val movies = viewModel.getMovie()
        assertNotNull(movies)
        assertEquals(10, movies.size)
    }
}