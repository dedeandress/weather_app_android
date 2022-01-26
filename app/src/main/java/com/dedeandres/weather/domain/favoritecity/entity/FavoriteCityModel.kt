package com.dedeandres.weather.domain.favoritecity.entity

data class FavoriteCityModel(
    val id: Int,
    val name: String,
    val feelsLike: Float,
    val wind: Float,
    val tempC: Float,
    val tempF: Float
)