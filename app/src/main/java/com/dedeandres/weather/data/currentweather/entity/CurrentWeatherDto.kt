package com.dedeandres.weather.data.currentweather.entity

import com.dedeandres.weather.domain.currentweather.entity.CurrentWeatherModel
import com.google.gson.annotations.SerializedName

data class CurrentWeatherDto(
    @SerializedName("location")
    val location: LocationBean,
    @SerializedName("current")
    val current: CurrentBean
){
    data class LocationBean(
        val name: String,
        val region: String,
        val country: String,
        val localtime: String,
    )

    data class CurrentBean(
        @SerializedName("temp_c")
        val tempC: Float,
        @SerializedName("temp_f")
        val tempF: Float,
        @SerializedName("last_updated")
        val lastUpdated: String,
        @SerializedName("condition")
        val condition: ConditionBean
    )

    data class ConditionBean(
        val text: String,
        @SerializedName("icon")
        val iconPath: String,
        val code: Int
    )

}

fun CurrentWeatherDto.mapToModel(): CurrentWeatherModel {
    return CurrentWeatherModel(
        locationName = this.location.name,
        locationCountry = this.location.country,
        tempC = this.current.tempC.toString(),
        tempF = this.current.tempF.toString(),
        tempLastUpdated = this.current.lastUpdated,
        conditionText = this.current.condition.text,
        conditionIconPath = this.current.condition.iconPath,
        conditionCode = this.current.condition.code
    )
}

