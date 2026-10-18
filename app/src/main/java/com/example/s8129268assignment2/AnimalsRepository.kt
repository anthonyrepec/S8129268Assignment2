package com.example.s8129268assignment2

import retrofit2.Response

class AnimalsRepository(private val apiService: AnimalsAPIService) {
    //Login Function
    suspend fun submitLoginDetails(newLogin: LoginRequest): Response<LoginResponse> {
        return apiService.submitLoginDetails(newLogin)
    }

    //Dashboard function (get all animals)
    suspend fun getDashboard(keypass: String): List<EntityResponse> {
        return apiService.getDashboard(keypass).body()?.entities.orEmpty()
    }
}