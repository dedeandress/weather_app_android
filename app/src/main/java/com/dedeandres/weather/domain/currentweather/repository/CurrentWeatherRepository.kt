package com.dedeandres.weather.domain.currentweather.repository

import com.dedeandres.weather.common.Either
import com.dedeandres.weather.domain.currentweather.entity.CurrentWeatherModel
import java.lang.Exception

interface CurrentWeatherRepository {
    suspend fun getCurrentWeather(location: String): Either<Exception, CurrentWeatherModel>
}