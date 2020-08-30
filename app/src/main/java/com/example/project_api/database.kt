package com.example.project_api

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.project_api.data.model.bebida
import com.example.project_api.domain.DaoBebida

@Database(entities = [bebida::class], version = 1)
abstract class database : RoomDatabase(){
    abstract fun daobebida() : DaoBebida
}
