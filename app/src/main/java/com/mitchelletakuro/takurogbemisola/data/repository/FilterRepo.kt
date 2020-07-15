package com.mitchelletakuro.takurogbemisola.data.repository

import com.mitchelletakuro.takurogbemisola.data.models.FilterModel
import com.mitchelletakuro.takurogbemisola.data.network.JsonFilterApi


class FilterRepo( private val filterApi:JsonFilterApi) {
    suspend fun fetchPosts():List<FilterModel> = filterApi.getPosts()


}

