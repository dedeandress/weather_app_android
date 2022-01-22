package com.dedeandres.weather.common

import com.dedeandres.weather.R

object Weather {
    fun getIcon(code: Int): Int{
        return when(code) {
            1000 -> R.drawable.ic_sunny
            1003 -> R.drawable.ic_partly_cloudy
            1006 -> R.drawable.ic_cloudy
            1009 -> R.drawable.ic_cloudy
            1030 -> R.drawable.ic_foggy
            1063 -> R.drawable.ic_rain //Patchy rain possible
            1066 -> R.drawable.ic_snow //Patchy snow possible
            1069 -> R.drawable.ic_rain //Patchy sleet possible
            1072 -> R.drawable.ic_rain //Patchy freezing drizzle possible
            1087 -> R.drawable.ic_storm //Thundery outbreaks possible
            1114 -> R.drawable.ic_snow
            1117 -> R.drawable.ic_snow
            1135 -> R.drawable.ic_foggy
            1147 -> R.drawable.ic_foggy
            1150 -> R.drawable.ic_rain
            1153 -> R.drawable.ic_rain
            1168 -> R.drawable.ic_rain
            1171 -> R.drawable.ic_rain
            1180 -> R.drawable.ic_rain
            1183 -> R.drawable.ic_rain
            1186 -> R.drawable.ic_rain
            1189 -> R.drawable.ic_rain
            1192 -> R.drawable.ic_rain
            1195 -> R.drawable.ic_rain
            1198 -> R.drawable.ic_rain
            1201 -> R.drawable.ic_rain
            1204 -> R.drawable.ic_rain
            1207 -> R.drawable.ic_rain
            1210 -> R.drawable.ic_rain
            1213 -> R.drawable.ic_rain
            1216 -> R.drawable.ic_snow
            1219 -> R.drawable.ic_snow
            1222 -> R.drawable.ic_snow
            1225 -> R.drawable.ic_snow
            1237 -> R.drawable.ic_snow
            1240 -> R.drawable.ic_snow
            1243 -> R.drawable.ic_snow
            1246 -> R.drawable.ic_rain
            1249 -> R.drawable.ic_rain
            1252 -> R.drawable.ic_rain
            1255 -> R.drawable.ic_snow
            1258 -> R.drawable.ic_snow
            1261 -> R.drawable.ic_rain
            1264 -> R.drawable.ic_rain
            1273 -> R.drawable.ic_storm
            1276 -> R.drawable.ic_storm
            1279 -> R.drawable.ic_storm
            1282 -> R.drawable.ic_storm



            else -> R.drawable.ic_rainbow
        }
    }
}