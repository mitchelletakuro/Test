package com.mitchelletakuro.takurogbemisola.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Filter (
    val gender: String,
    val colors: List<String>,
    val car_model_startYear: Int,
    val end_model_endYear: Int,
    val car_model_year:Int,
    val countries: List<String>
) : Parcelable
