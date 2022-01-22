package com.dedeandres.weather.domain.currentweather.entity

import com.dedeandres.weather.presenter.dashboard.entity.CurrentWeatherResult

data class CurrentWeatherModel(
    val locationName: String,
    val locationCountry: String,
    val tempC: String,
    val tempF: String,
    val tempLastUpdated: String,
    val conditionText: String,
    val conditionIconPath: String,
    val conditionCode: Int
)

fun CurrentWeatherModel.mapToResult(): CurrentWeatherResult = CurrentWeatherResult(
    locationName, locationCountry, tempC, tempF, tempLastUpdated, conditionText, conditionIconPath, conditionCode
)

