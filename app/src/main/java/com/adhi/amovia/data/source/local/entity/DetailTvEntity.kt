package com.adhi.amovia.data.source.local.entity

data class DetailTvEntity(
    val id: Int,
    val imgPoster: String,
    val name: String,
    val tagline: String,
    val rating: Double,
    val ratingCount: Int,
    val firstAir: String,
    val runtime: Int,
    val overview: String
)
