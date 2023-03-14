package com.example.data.repository

import com.example.data.mapper.toDomainResponse
import com.example.data.network.ApiService
import com.example.domain.model.Repository
import com.example.domain.repository.HomeRepository

class HomeRepositoryImpl(private val apiService: ApiService) : HomeRepository {
    override suspend fun getAllRepository(page: Int, per_page: Int): List<Repository> {
        return apiService.getAllRepo(page, per_page).map { it.toDomainResponse() }
    }
}