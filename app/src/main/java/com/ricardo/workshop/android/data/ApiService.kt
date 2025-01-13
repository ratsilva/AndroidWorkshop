package com.ricardo.workshop.android.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

internal interface ApiService {
    @GET("items")
    suspend fun getToasts(): List<Toast>
}

internal object ApiServiceFactory {

    fun createApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/sumup-challenges/mobile-coding-challenge-data/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}