package com.mitchelletakuro.takurogbemisola.data.network


import com.mitchelletakuro.takurogbemisola.data.models.PostsModel
import retrofit2.http.GET

/**
 * Created by manuelchris-ogar on 14/07/2020.
 */
interface JsonPostsApi {

    @GET("/posts")
    suspend fun getPosts():List<PostsModel>
}