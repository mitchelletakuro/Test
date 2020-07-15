package com.mitchelletakuro.takurogbemisola.data.network


import com.mitchelletakuro.takurogbemisola.data.models.FilterModel
import retrofit2.http.GET

/**
 * Created by manuelchris-ogar on 14/07/2020.
 */
interface JsonFilterApi {

    @GET("assets/filter.json")
    suspend fun getPosts():List<FilterModel>
}