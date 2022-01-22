package com.dedeandres.weather.data.currentweather.api

import com.dedeandres.weather.data.currentweather.entity.CurrentWeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface GetCurrentWeatherApi {
    @GET("v1/current.json")
    suspend fun getCurrentWeather(@Query("key") key: String, @Query("q") location: String): CurrentWeatherDto
}