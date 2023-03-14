package com.example.domain.use_case

import com.example.commons.utlis.Resource
import com.example.domain.model.Repository
import com.example.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetHomeRepositoryUseCase(private val homeRepository: HomeRepository) {
    operator fun invoke(page: Int, per_page: Int): Flow<Resource<List<Repository>>> = flow {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(data = homeRepository.getAllRepository(page, per_page)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message.toString()))
        }
    }
}