package com.dedeandres.weather.di.repository

import com.dedeandres.weather.common.room.dao.FavoriteCityDao
import com.dedeandres.weather.data.favoritecity.repository.FavoriteCityRepositoryImpl
import com.dedeandres.weather.domain.favoritecity.repository.FavoriteCityRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class FavoriteCityRepositoryModule {

    @Provides
    fun provideFavoriteCityRepository(favoriteCityDao: FavoriteCityDao): FavoriteCityRepository{
        return FavoriteCityRepositoryImpl(favoriteCityDao)
    }

}