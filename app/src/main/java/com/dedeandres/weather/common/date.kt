package com.dedeandres.weather.common

import android.text.format.DateFormat;
import java.util.*

fun getDayOfTheWeek(): String{
    val calendar = Calendar.getInstance()

    return DateFormat.format("EEEE", calendar).toString()
}

fun getDate(): String{
    val calendar = Calendar.getInstance()
    val month = DateFormat.format("MMMM", calendar)
    val day = DateFormat.format("dd", calendar)


    return "$month $day"
}