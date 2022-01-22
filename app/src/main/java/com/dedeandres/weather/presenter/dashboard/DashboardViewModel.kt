package com.dedeandres.weather.presenter.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dedeandres.weather.common.Event
import com.dedeandres.weather.common.Resource
import com.dedeandres.weather.common.setErrorEvent
import com.dedeandres.weather.common.setSuccessEvent
import com.dedeandres.weather.domain.currentweather.usecase.FetchCurrentWeatherUsecase
import com.dedeandres.weather.presenter.dashboard.entity.CurrentWeatherResult
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val fetchCurrentWeatherUsecase: FetchCurrentWeatherUsecase
): ViewModel(){
    val fetchCurrentWeatherLiveData = MutableLiveData<Event<Resource<CurrentWeatherResult>>>()

    fun fetchCurrentWeather(){
        fetchCurrentWeatherUsecase(mapOf(FetchCurrentWeatherUsecase.LOCATION to "Jakarta")){
            it.fold(
                { exception ->
                    Timber.d("currentWeather exception: $exception")
                    fetchCurrentWeatherLiveData.setErrorEvent(exception)
                },
                { currentWeatherResult ->
                    Timber.d("currentWeather: $currentWeatherResult")
                    fetchCurrentWeatherLiveData.setSuccessEvent(currentWeatherResult)
                }
            )
        }
    }
}