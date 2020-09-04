package com.example.project_api.db.dao

import com.example.project_api.models.bebida
import com.example.project_api.db.dao.DrinkDao
import com.example.project_api.domain.DrinkDataSource
import com.example.project_api.api.DrinkRetroClient
import com.example.project_api.vo.Resource
import javax.inject.Inject

class DrinkDataSourceImpl @Inject constructor (private val drinkDao: DrinkDao) : DrinkDataSource{

      override suspend fun getBebidaNombre(bebidaName: String) : Resource<List<bebida>> {
            return Resource.Success(DrinkRetroClient.webservice.getBebidaName(bebidaName).bebidaList)
        }

        override suspend fun savebebidaroom(bebida: bebida){
            drinkDao.insertarFav(bebida)
        }

        override suspend fun getbebidafav(): Resource<List<bebida>> {
            return Resource.Success(drinkDao.obtenerBebidas())
        }
}