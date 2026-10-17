package com.example.s8129268assignment2

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AnimalsAPIService {

    //POST request to send login details to https://nit3213apinew.onrender.com/footscray/auth
    @POST("footscray/auth")
    suspend fun submitLoginDetails(@Body body: LoginRequest): Response<LoginResponse>
}