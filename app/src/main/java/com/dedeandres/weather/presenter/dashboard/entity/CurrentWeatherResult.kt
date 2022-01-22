package com.dedeandres.weather.presenter.dashboard.entity

data class CurrentWeatherResult(
    private val locationName: String,
    private val locationCountry: String,
    private val tempC: String,
    private val tempF: String,
    private val tempLastUpdated: String,
    private val conditionText: String,
    private val conditionIconPath: String,
)