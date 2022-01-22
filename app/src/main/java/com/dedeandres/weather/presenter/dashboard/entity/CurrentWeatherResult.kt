package com.dedeandres.weather.presenter.dashboard.entity

data class CurrentWeatherResult(
    val locationName: String,
    val locationCountry: String,
    val tempC: String,
    val tempF: String,
    val tempLastUpdated: String,
    val conditionText: String,
    val conditionIconPath: String,
    val coditionCode: Int
)