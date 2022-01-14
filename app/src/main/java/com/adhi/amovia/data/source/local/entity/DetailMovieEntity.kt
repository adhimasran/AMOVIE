package com.adhi.amovia.data.source.local.entity

data class DetailMovieEntity(
    val id: Int,
    val imgPoster: String,
    val title: String,
    val tagline: String,
    val rating: Double,
    val ratingCount: Int,
    val release: String,
    val runtime: Int,
    val overview: String
)
