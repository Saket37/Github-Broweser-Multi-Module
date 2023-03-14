package com.example.data.di

import com.example.data.network.ApiService
import com.example.data.repository.HomeRepositoryImpl
import com.example.domain.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@InstallIn(SingletonComponent::class)
@Module
object HomeDataModule {
    @Provides
    fun provideRepositoryApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun providesHomeRepository(apiService: ApiService): HomeRepository {
        return HomeRepositoryImpl(apiService)
    }
}