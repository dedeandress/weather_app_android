package com.dedeandres.weather.data.currentweather.repository

import com.dedeandres.weather.BuildConfig
import com.dedeandres.weather.common.Either
import com.dedeandres.weather.common.HttpErrorHandler
import com.dedeandres.weather.data.currentweather.api.GetCurrentWeatherApi
import com.dedeandres.weather.data.currentweather.entity.mapToModel
import com.dedeandres.weather.domain.currentweather.entity.CurrentWeatherModel
import com.dedeandres.weather.domain.currentweather.repository.CurrentWeatherRepository
import java.lang.Exception

class CurrentWeatherRepositoryImpl(private val currentWeatherApi: GetCurrentWeatherApi, private val errorHandler: HttpErrorHandler) : CurrentWeatherRepository {
    override suspend fun getCurrentWeather(location: String): Either<Exception, CurrentWeatherModel> {
        return try{
            Either.Right(currentWeatherApi.getCurrentWeather(BuildConfig.API_KEY, location).mapToModel())
        }catch (e: Exception){
            Either.Left(errorHandler.handleException(e))
        }
    }
}