package com.example.s8129268assignment2

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

class APIClient {
    //Class to create the retrofit API instance that will be used throughout the program
    //Targets the NIT3213 API and binds the Gson conversion tools
    @Module
    @InstallIn(SingletonComponent::class)
    object NetworkModule {
        @Provides
        @Singleton
        fun provideApi(): AnimalsAPIService {
            return Retrofit.Builder()
                .baseUrl("https://nit3213apinew.onrender.com/")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(AnimalsAPIService::class.java)
        }
    }
}