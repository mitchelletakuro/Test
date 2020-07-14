package com.mitchelletakuro.takurogbemisola.data.network

import com.mitchelletakuro.takurogbemisola.data.models.Filter
import retrofit2.http.GET

interface FilterInterface {
    @GET("accounts")
    suspend fun fetchFilters(): List<Filter>

}