package com.example.project_api.domain

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.project_api.data.model.bebida

@Dao
interface DrinkDao {

    @Query("SELECT * FROM EntityBebida")
    suspend fun obtenerBebidas():List<bebida>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarFav(coctel: bebida)
}