package com.dedeandres.weather.presenter.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dedeandres.weather.common.Event
import com.dedeandres.weather.common.Resource
import com.dedeandres.weather.common.setErrorEvent
import com.dedeandres.weather.common.setSuccessEvent
import com.dedeandres.weather.domain.currentweather.usecase.FetchCurrentWeatherUsecase
import com.dedeandres.weather.domain.favoritecity.usecase.DeleteFavoriteCityUsecase
import com.dedeandres.weather.domain.favoritecity.usecase.FetchFavoriteCityWeatherList
import com.dedeandres.weather.domain.favoritecity.usecase.SaveFavoriteCityUsecase
import com.dedeandres.weather.presenter.dashboard.entity.CityWeatherResult
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val fetchCurrentWeatherUsecase: FetchCurrentWeatherUsecase,
    private val fetchFavoriteCityWeatherList: FetchFavoriteCityWeatherList,
    private val saveFavoriteCityUsecase: SaveFavoriteCityUsecase,
    private val deleteFavoriteCityUsecase: DeleteFavoriteCityUsecase
): ViewModel(){
    val fetchCurrentWeatherLiveData = MutableLiveData<Event<Resource<CityWeatherResult>>>()
    val fetchFavoriteCityWeatherListLiveData = MutableLiveData<Event<Resource<List<CityWeatherResult>>>>()

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

    fun fetchFavoriteCityWeatherList(){
        fetchFavoriteCityWeatherList{
            it.fold(
                { exception ->
                    Timber.d("favorite city weather list exception: $exception")
                    fetchFavoriteCityWeatherListLiveData.setErrorEvent(exception)
                },
                { favoriteCityList ->
                    Timber.d("favorite city weather list: $favoriteCityList")
                    fetchFavoriteCityWeatherListLiveData.setSuccessEvent(favoriteCityList)
                }
            )
        }
    }

    fun saveFavoriteCity(name: String){
        saveFavoriteCityUsecase(mapOf(SaveFavoriteCityUsecase.NAME to name))
    }

    fun deleteFavoriteCity(id: Int){
        deleteFavoriteCityUsecase(mapOf(DeleteFavoriteCityUsecase.ID to id))
    }
}