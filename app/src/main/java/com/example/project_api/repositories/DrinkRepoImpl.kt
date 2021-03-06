package com.example.project_api.repositories

import com.example.project_api.models.bebida
import com.example.project_api.domain.DrinkDataSource
import com.example.project_api.vo.Resource
import javax.inject.Inject

class DrinkRepoImpl @Inject constructor (private  val drinkDataSource: DrinkDataSource):
    DrinkRepository {
    override suspend fun getBebidaList(bebidaName: String): Resource<List<bebida>> {
        return drinkDataSource.getBebidaNombre(bebidaName)
    }

    override suspend fun getFavBebidad(): Resource<List<bebida>> {
        return drinkDataSource.getbebidafav()
    }

    override suspend fun SaveBebida(bebida: bebida) {
       drinkDataSource.savebebidaroom(bebida)
    }
}