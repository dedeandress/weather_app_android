package com.dedeandres.weather.data.favoritecity.repository

import com.dedeandres.weather.common.room.dao.FavoriteCityDao
import com.dedeandres.weather.data.favoritecity.entity.FavoriteCity
import com.dedeandres.weather.data.favoritecity.entity.mapToModel
import com.dedeandres.weather.domain.favoritecity.entity.FavoriteCityModel
import com.dedeandres.weather.domain.favoritecity.repository.FavoriteCityRepository
import javax.inject.Inject

class FavoriteCityRepositoryImpl @Inject constructor(private val favoriteCityDao: FavoriteCityDao): FavoriteCityRepository {
    override suspend fun getAllFavoriteCity(): List<FavoriteCityModel> {
        return favoriteCityDao.getAll().map { it.mapToModel() }
    }

    override suspend fun insertFavoriteCity(name: String) {
        return favoriteCityDao.insert(favoriteCity = FavoriteCity(name = name))
    }

    override suspend fun deleteFavoriteCity(id: Int) {
        return favoriteCityDao.delete(id)
    }
}