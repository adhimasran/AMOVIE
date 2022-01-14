package com.adhi.amovia.ui.tv

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.adhi.amovia.data.source.FilmRepository
import com.adhi.amovia.data.source.local.entity.TvEntity
import com.adhi.amovia.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {
    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: FilmRepository

    @Mock
    private lateinit var observer: Observer<List<TvEntity>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(repo)
    }

    @Test
    fun getTvShow() {
        val dummyTvShows = DataDummy.dummyTvShows()
        val data = MutableLiveData<List<TvEntity>>()
        data.value = dummyTvShows

        `when`(repo.getTvShows()).thenReturn(data)
        val tvShows = viewModel.getTvShows().value
        verify(repo).getTvShows()
        assertNotNull(tvShows)
        assertEquals(6, tvShows?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShows)
    }
}