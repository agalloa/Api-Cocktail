package com.example.project_api.api

import com.example.project_api.models.BebidaList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("search.php")
    suspend fun getBebidaName(@Query(value = "s") bebidaNombre: String): BebidaList
}