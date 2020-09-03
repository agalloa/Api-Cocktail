package com.example.project_api.domain

import com.example.project_api.data.model.bebida
import com.example.project_api.vo.Resource

interface DrinkDataSource {
       suspend fun getBebidaNombre(bebidaName: String) : Resource<List<bebida>>
       suspend fun savebebidaroom(bebida:bebida)
       suspend fun getbebidafav(): Resource<List<bebida>>

}
