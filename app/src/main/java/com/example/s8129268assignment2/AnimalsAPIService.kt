package com.example.s8129268assignment2

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AnimalsAPIService {

    //POST request to send login details to https://nit3213apinew.onrender.com/footscray/auth
    @POST("footscray/auth")
    suspend fun submitLoginDetails(@Body body: LoginRequest): Response<LoginResponse>

    @GET("dashboard/{keypass}")
    suspend fun getDashboard(@Path("keypass") keypass: String): Response<DashboardResponse>

    //GET request to retrieve the list of animals and the total number
    data class DashboardResponse(
        val entities: List<Entity>,
        val entityTotal: Int
    )

    //GET request to retrieve the details of a particular animal
    data class Entity(
        val species: String,
        val scientificName: String,
        val habitat: String,
        val diet: String,
        val conservationStatus: String,
        val averageLifespan: Int,
        val description: String
    )
}