package com.adhi.amovia.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.adhi.amovia.data.source.FilmRepository
import com.adhi.amovia.data.source.local.entity.DetailMovieEntity
import com.adhi.amovia.utils.DataDummy
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
class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.dummyMovie()
    private val id = dummyMovie.id
    private val data = MutableLiveData<DetailMovieEntity>()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: FilmRepository

    @Mock
    private lateinit var observer: Observer<DetailMovieEntity>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(repo)
    }

    @Test
    fun getMovie() {
        data.value = dummyMovie

        `when`(repo.getDetailMovie(id)).thenReturn(data)
        val movie = viewModel.getDetailMovie(id).value
        verify(repo).getDetailMovie(id)
        assertNotNull(movie)

        viewModel.getDetailMovie(id).observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}