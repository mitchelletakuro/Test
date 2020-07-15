package com.mitchelletakuro.takurogbemisola.data.models

import com.google.gson.annotations.SerializedName

data class FilterModel(
        @SerializedName("gender")
        var gender: String,
        @SerializedName("colors")
        var colors: List<String>,
        @SerializedName("carModel_startYear")
        var carModel_startYear:Int,
        @SerializedName("carModel_endYear")
        var carModel_endYear:Int,
        @SerializedName("countries")
        var countries: List<String>


)
