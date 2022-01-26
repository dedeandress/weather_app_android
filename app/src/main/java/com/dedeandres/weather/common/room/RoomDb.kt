package com.dedeandres.weather.common.room

import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.dedeandres.weather.common.room.dao.FavoriteCityDao
import com.dedeandres.weather.data.favoritecity.entity.FavoriteCity

@Database(
    entities = [FavoriteCity::class],
    version = 1
)
abstract class RoomDb : RoomDatabase() {
    abstract fun favoriteCityDao(): FavoriteCityDao
}