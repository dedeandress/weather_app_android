package com.dedeandres.weather.presenter.dashboard.entity

data class CityWeatherResult(
    val id: Int?=null,
    val locationName: String,
    val locationCountry: String,
    val tempC: String,
    val tempF: String,
    val windKph: String,
    val windMph: String,
    val feelsLikeC: String,
    val feelsLikeF: String,
    val tempLastUpdated: String,
    val conditionText: String,
    val conditionIconPath: String,
    val coditionCode: Int
)