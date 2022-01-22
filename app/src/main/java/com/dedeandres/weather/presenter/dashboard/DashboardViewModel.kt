package com.dedeandres.weather.presenter.dashboard

import androidx.lifecycle.ViewModel
import com.dedeandres.weather.domain.currentweather.usecase.FetchCurrentWeatherUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val fetchCurrentWeatherUsecase: FetchCurrentWeatherUsecase
): ViewModel(){
    fun fetchCurrentWeather(){
        fetchCurrentWeatherUsecase(mapOf(FetchCurrentWeatherUsecase.LOCATION to "Jakarta")){
            it.fold(
                { exception ->
                    Timber.d("currentWeather exception: ${exception}")
                },
                { currentWeatherResult ->
                    Timber.d("currentWeather: ${currentWeatherResult}")
                }
            )
        }
    }
}