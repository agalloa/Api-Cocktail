package com.example.project_api.domain

import com.example.project_api.data.model.BebidaList
import com.example.project_api.data.model.bebida
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("search.php")
    suspend fun getBebidaName(@Query(value = "s") bebidaNombre: String): BebidaList
}