package com.example.data.network

import com.example.commons.utlis.Constants
import com.example.data.model.RepositoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("users/" + Constants.GITHUB_USER_NAME + "/repos")
    suspend fun getAllRepo(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int,

        ): List<RepositoryResponse>
}