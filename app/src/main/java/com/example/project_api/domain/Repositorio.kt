package com.example.project_api.domain

import com.example.project_api.data.model.bebida
import com.example.project_api.vo.Resource

interface Repositorio {
    suspend fun getBebidaList(bebidaName: String):Resource<List<bebida>>
    suspend fun getFavBebidad():Resource<List<bebida>>
    suspend fun SaveBebida(bebida:bebida)
}