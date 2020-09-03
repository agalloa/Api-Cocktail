package com.example.project_api.di

import com.example.project_api.data.DrinkDataSourceImpl
import com.example.project_api.domain.DrinkDataSource
import com.example.project_api.domain.DrinkRepoImpl
import com.example.project_api.domain.DrinkRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ModuleActivity {

    @Binds
    abstract fun ImplRepoBind(drinkRepoImpl: DrinkRepoImpl): DrinkRepository

    @Binds
    abstract fun DataSourceImplBind(drinkDataSourceImpl: DrinkDataSourceImpl) : DrinkDataSource
}
