package com.dedeandres.weather.domain.currentweather.usecase

import com.dedeandres.weather.common.Either
import com.dedeandres.weather.common.base.BaseUseCase
import com.dedeandres.weather.common.map
import com.dedeandres.weather.domain.currentweather.entity.mapToResult
import com.dedeandres.weather.domain.currentweather.repository.CurrentWeatherRepository
import com.dedeandres.weather.presenter.dashboard.entity.CityWeatherResult
import javax.inject.Inject

class FetchCurrentWeatherUsecase @Inject constructor(private val currentWeatherRepository: CurrentWeatherRepository)
    : BaseUseCase<CityWeatherResult>(){
    override suspend fun buildUseCase(data: Map<String, Any?>): Either<Exception, CityWeatherResult> {
        return currentWeatherRepository.getCurrentWeather(data[LOCATION] as String).map{
            it.mapToResult()
        }
    }

    companion object{
        val LOCATION = "location"
    }
}