package com.example.project_api.domain

import com.example.project_api.data.model.bebida
import com.example.project_api.vo.Resource
import javax.inject.Inject

class ImplRepo @Inject constructor (private  val dataSource: DataSource): Repositorio {
    override suspend fun getBebidaList(bebidaName: String): Resource<List<bebida>> {
        return dataSource.getBebidaNombre(bebidaName)
    }

    override suspend fun getFavBebidad(): Resource<List<bebida>> {
        return dataSource.getbebidafav()
    }

    override suspend fun SaveBebida(bebida: bebida) {
       dataSource.savebebidaroom(bebida)
    }
}