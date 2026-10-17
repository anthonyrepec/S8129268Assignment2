package com.example.s8129268assignment2

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

//Dataclass for the POST request the server with login details
@JsonClass(generateAdapter = true)
data class LoginRequest(
    @Json(name = "username") val username: String,
    @Json(name = "password") val password: String
)

//Dataclass to handle the keypass obtained on successful login
@JsonClass(generateAdapter = true)
data class LoginResponse(
    @Json(name = "keypass") val keypass: String
)


//Dataclass to handle the GET request for animals (which provides a list of entities and the total amount)
@JsonClass(generateAdapter = true)
data class DashboardResponse(
    @Json(name = "entities") val entities: List<EntityResponse>,
    @Json(name = "entityTotal") val entityTotal: Int
)

//Dataclass to handle the individual species data queried from the server
@JsonClass(generateAdapter = true)
data class EntityResponse(
    @Json(name = "species") val species: String,
    @Json(name = "scientificName") val scientificName: String,
    @Json(name = "habitat") val habitat: String,
    @Json(name = "diet") val diet: String,
    @Json(name = "conservationStatus") val conservationStatus: String,
    @Json(name = "averageLifespan") val averageLifespan: Int,
    @Json(name = "description") val description: String
)