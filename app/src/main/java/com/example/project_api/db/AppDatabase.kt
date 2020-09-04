package com.example.project_api.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.project_api.models.bebida
import com.example.project_api.db.dao.DrinkDao

@Database(entities = [bebida::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun daobebida() : DrinkDao
}
