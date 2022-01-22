package com.dedeandres.weather.di.repository

import com.dedeandres.weather.common.HttpErrorHandler
import com.dedeandres.weather.common.services
import com.dedeandres.weather.data.currentweather.api.GetCurrentWeatherApi
import com.dedeandres.weather.data.currentweather.repository.CurrentWeatherRepositoryImpl
import com.dedeandres.weather.domain.currentweather.repository.CurrentWeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class CurrentWeatherRepositoryModule {

    @Provides
    fun provideCurrentWeatherApi(
        retrofit: Retrofit
    ): GetCurrentWeatherApi{
        return services(retrofit)
    }

    @Provides
    fun provideCurrentWeatherRepository(
        getCurrentWeatherApi: GetCurrentWeatherApi,
        httpErrorHandler: HttpErrorHandler,
    ): CurrentWeatherRepository{
        return CurrentWeatherRepositoryImpl(getCurrentWeatherApi, httpErrorHandler)
    }
}