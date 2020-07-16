package com.mitchelletakuro.takurogbemisola.data.network


import com.mitchelletakuro.takurogbemisola.data.models.FilterModel
import retrofit2.http.GET


interface JsonFilterApi {

    @GET("assets/filter.json")
    suspend fun getPosts():List<FilterModel>
}