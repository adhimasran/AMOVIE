package com.adhi.amovia.ui.tvshow

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test

class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShow() {
        val show = viewModel.getTvShow()
        assertNotNull(show)
        assertEquals(10, show.size)
    }
}