package com.example.project_api.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.project_api.data.model.bebidaEntity
import androidx.room.Query

@Dao
interface DaoBebida {

    @Query("SELECT * FROM EntityBebida")
    suspend fun obtenerBebidas():List<bebidaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarFav(coctel:bebidaEntity)
}