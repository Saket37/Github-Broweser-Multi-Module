package com.example.commons.network

import com.example.commons.utlis.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object ApiModule {
    @Provides
    @Singleton
    fun getRetrofitService(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.API_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
        //.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun clientBuilder(): OkHttpClient {
        // Interceptor to enable logging in Debug
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
            // if (com.example..BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        }
        /*val tokenInterceptor = Interceptor {
            val request = it.request().newBuilder()
                .addHeader("Authorization", "token ${Constants.API_KEY}")
                .build()
            it.proceed(request)
        }*/
        val httpClient = OkHttpClient.Builder().apply {
            addInterceptor(interceptor)
            // addInterceptor(tokenInterceptor)
            connectTimeout(2, TimeUnit.MINUTES)
            readTimeout(2, TimeUnit.MINUTES)
            writeTimeout(4, TimeUnit.MINUTES)
        }

        return httpClient.build()
    }
}