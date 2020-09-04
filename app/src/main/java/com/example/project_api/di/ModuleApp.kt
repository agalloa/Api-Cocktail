package com.example.project_api.di

import android.content.Context
import androidx.room.Room
import com.example.project_api.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object ModuleApp {
    @Singleton
    @Provides
    fun RoomInstanceProvider(@ApplicationContext context: Context)
            = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java,"tabla_bebidas").build()

    @Singleton
    @Provides
    fun DaoBebidaProvider(bd: AppDatabase) = bd.daobebida()
}