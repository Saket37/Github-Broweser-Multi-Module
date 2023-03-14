package com.example.domain.repository

import com.example.domain.model.Repository

interface HomeRepository {
    suspend fun getAllRepository(page: Int, per_page: Int): List<Repository>
}