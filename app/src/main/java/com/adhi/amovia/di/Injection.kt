package com.adhi.amovia.di

import com.adhi.amovia.data.source.FilmRepository
import com.adhi.amovia.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(): FilmRepository {
        val remoteDataSource = RemoteDataSource.getInstance()

        return FilmRepository.getInstance(remoteDataSource)
    }
}