package com.mitchelletakuro.takurogbemisola.data.network

import com.mitchelletakuro.takurogbemisola.data.models.FilterModel
import retrofit2.http.GET

interface FilterInterface {
    @GET("accounts")
    suspend fun fetchFilters(): List<FilterModel>

}