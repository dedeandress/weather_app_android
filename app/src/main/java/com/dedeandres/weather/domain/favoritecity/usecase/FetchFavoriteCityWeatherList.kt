package com.dedeandres.weather.domain.favoritecity.usecase

import com.dedeandres.weather.common.Either
import com.dedeandres.weather.common.base.BaseUseCase
import com.dedeandres.weather.domain.currentweather.entity.mapToResult
import com.dedeandres.weather.domain.currentweather.repository.CurrentWeatherRepository
import com.dedeandres.weather.domain.favoritecity.repository.FavoriteCityRepository
import com.dedeandres.weather.presenter.dashboard.entity.CityWeatherResult
import timber.log.Timber
import javax.inject.Inject

class FetchFavoriteCityWeatherList @Inject constructor(private val favoriteCityRepository: FavoriteCityRepository, private val currentWeatherRepository: CurrentWeatherRepository) : BaseUseCase<List<CityWeatherResult>>() {
    override suspend fun buildUseCase(data: Map<String, Any?>): Either<Exception, List<CityWeatherResult>> {
        val favoriteCityList = favoriteCityRepository.getAllFavoriteCity()

        val cityWeatherList = arrayListOf<CityWeatherResult>()
        favoriteCityList.forEach { favoriteCity ->
            val cityWeather = currentWeatherRepository.getCurrentWeather(favoriteCity.name)
            cityWeather.fold(
                { exception ->
                    Timber.d("Cannot Fetch Weather: ${favoriteCity.name} with exception: ${exception.message}")
                },{ currentWeatherModel ->
                    cityWeatherList.add(currentWeatherModel.mapToResult(favoriteCity.id))
                }
            )
        }

        return Either.Right(cityWeatherList)
    }
}