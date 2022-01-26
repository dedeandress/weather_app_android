package com.dedeandres.weather.domain.currentweather.entity

import com.dedeandres.weather.presenter.dashboard.entity.CityWeatherResult

data class CurrentWeatherModel(
    val locationName: String,
    val locationCountry: String,
    val tempC: String,
    val tempF: String,
    val feelsLikeC: String,
    val feelsLikeF: String,
    val windKph: String,
    val windMph: String,
    val tempLastUpdated: String,
    val conditionText: String,
    val conditionIconPath: String,
    val conditionCode: Int
)

fun CurrentWeatherModel.mapToResult(id: Int?=null): CityWeatherResult = CityWeatherResult(
    id, locationName, locationCountry, tempC, tempF, windKph, windMph, feelsLikeC, feelsLikeF, tempLastUpdated, conditionText, conditionIconPath, conditionCode
)

