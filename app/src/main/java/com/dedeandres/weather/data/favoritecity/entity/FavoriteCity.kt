package com.dedeandres.weather.data.favoritecity.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dedeandres.weather.domain.favoritecity.entity.FavoriteCityModel
import java.util.*

@Entity(tableName = "favorite_city")
data class FavoriteCity (
    @PrimaryKey(autoGenerate = true) val id: Int?=null,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "feels_like") val feelsLike: Float = 0f,
    @ColumnInfo(name = "wind") val wind: Float = 0f,
    @ColumnInfo(name = "tempC") val tempC: Float = 0f,
    @ColumnInfo(name = "tempF") val tempF: Float = 0f,
)

fun FavoriteCity.mapToModel(): FavoriteCityModel = FavoriteCityModel(id ?: 0, name, feelsLike, wind, tempC, tempF)

fun List<FavoriteCity>.mapToModel(): List<FavoriteCityModel> {
    return map {
        it.mapToModel()
    }
}