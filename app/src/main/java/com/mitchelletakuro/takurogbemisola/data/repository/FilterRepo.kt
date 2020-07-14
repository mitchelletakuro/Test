package com.mitchelletakuro.takurogbemisola.data.repository

import com.mitchelletakuro.takurogbemisola.data.models.Filter
import com.mitchelletakuro.takurogbemisola.data.network.FilterInterface
import com.mitchelletakuro.takurogbemisola.data.network.JsonPostsApi


class FilterRepo( private val postsApi:JsonPostsApi) {
    suspend fun fetchPosts() = postsApi.getPosts()

}

