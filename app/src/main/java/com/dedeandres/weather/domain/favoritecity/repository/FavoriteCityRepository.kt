package com.dedeandres.weather.domain.favoritecity.repository

import com.dedeandres.weather.domain.favoritecity.entity.FavoriteCityModel

interface FavoriteCityRepository {

    suspend fun getAllFavoriteCity(): List<FavoriteCityModel>

    suspend fun insertFavoriteCity(name: String)

    suspend fun deleteFavoriteCity(id: Int)

}