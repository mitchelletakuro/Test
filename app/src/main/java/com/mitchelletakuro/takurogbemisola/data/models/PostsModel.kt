package com.mitchelletakuro.takurogbemisola.data.models

import com.google.gson.annotations.SerializedName

/**
 * Created by manuelchris-ogar on 14/07/2020.
 */
data class PostsModel(
        @SerializedName("body")
        var body: String,
        @SerializedName("id")
        var id: Int,
        @SerializedName("title")
        var title: String,
        @SerializedName("userId")
        var userId: Int
)
