package com.example.project_api

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.project_api.data.model.bebidaEntity
import com.example.project_api.domain.DaoBebida

@Database(entities = [bebidaEntity::class], version = 1)
abstract class database : RoomDatabase(){
    abstract fun daobebida() : DaoBebida
   /*
    companion object{
        private var INSTANCE: database? =null
        fun obtenerBD(context: Context): database{
            INSTANCE = INSTANCE ?: Room.databaseBuilder(context.applicationContext, database::class.java,"tabla_bebidas").build()
            return INSTANCE!!
        }

        fun instanceDestroy(){
            INSTANCE = null
        }
    }

    */
}
