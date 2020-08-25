package com.example.project_api.data

import androidx.room.Dao
import com.example.project_api.data.model.bebida
import com.example.project_api.data.model.bebidaEntity
import com.example.project_api.database
import com.example.project_api.domain.DaoBebida
import com.example.project_api.domain.DataSource
import com.example.project_api.vo.ClienteRetro
import com.example.project_api.vo.Resource
import javax.inject.Inject

class DataSourceImpl @Inject constructor (private val daoBebida: DaoBebida) : DataSource{

      override suspend fun getBebidaNombre(bebidaName: String) : Resource<List<bebida>> {
            return Resource.Success(ClienteRetro.webservice.getBebidaName(bebidaName).bebidaList)
        }

        override suspend fun savebebidaroom(bebida: bebidaEntity){
            daoBebida.insertarFav(bebida)
        }

        override suspend fun getbebidafav(): Resource<List<bebidaEntity>> {
            return Resource.Success(daoBebida.obtenerBebidas())
        }
}