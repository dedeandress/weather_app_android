package com.dedeandres.weather.common.room.dao

import androidx.room.*
import com.dedeandres.weather.data.favoritecity.entity.FavoriteCity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteCityDao {

    @Query("SELECT * from favorite_city")
    fun getAll(): List<FavoriteCity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(favoriteCity: FavoriteCity)

    @Query("DELETE FROM favorite_city where id = :favoriteCityId")
    fun delete(favoriteCityId: Int)
}