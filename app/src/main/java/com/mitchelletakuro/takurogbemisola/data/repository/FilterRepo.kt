package com.mitchelletakuro.takurogbemisola.data.repository

import com.mitchelletakuro.takurogbemisola.data.models.FilterModel
import com.mitchelletakuro.takurogbemisola.data.network.JsonFilterApi
import kotlinx.coroutines.Deferred


class FilterRepo( private val filterApi:JsonFilterApi) {
    suspend fun fetchPosts(): List<FilterModel> = filterApi.getPosts()



}

