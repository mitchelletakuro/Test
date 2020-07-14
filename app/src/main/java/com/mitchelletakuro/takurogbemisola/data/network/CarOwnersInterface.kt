package com.mitchelletakuro.takurogbemisola.data.network


import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Streaming
import retrofit2.http.Url


interface CarOwnersInterface {
    @GET
    @Streaming
    suspend fun downloadFile(@Url fileUrl: String): Call<ResponseBody>
}

