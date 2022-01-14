package com.adhi.amovia.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.adhi.amovia.data.source.FilmRepository
import com.adhi.amovia.data.source.local.entity.DetailTvEntity
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
class DetailTvViewModelTest {
    private lateinit var viewModel: DetailTvViewModel
    private val dummyTv = DataDummy.dummyTv()
    private val id = dummyTv.id
    private val data = MutableLiveData<DetailTvEntity>()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: FilmRepository

    @Mock
    private lateinit var observer: Observer<DetailTvEntity>

    @Before
    fun setUp() {
        viewModel = DetailTvViewModel(repo)
    }

    @Test
    fun getTv() {
        data.value = dummyTv

        `when`(repo.getDetailTv(id)).thenReturn(data)
        val movie = viewModel.getDetailTv(id).value
        verify(repo).getDetailTv(id)
        assertNotNull(movie)

        viewModel.getDetailTv(id).observeForever(observer)
        verify(observer).onChanged(dummyTv)
    }
}