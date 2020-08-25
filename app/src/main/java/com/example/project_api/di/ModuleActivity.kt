package com.example.project_api.di

import com.example.project_api.data.DataSourceImpl
import com.example.project_api.domain.DataSource
import com.example.project_api.domain.ImplRepo
import com.example.project_api.domain.Repositorio
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class ModuleActivity {

    @Binds
    abstract fun ImplRepoBind(implRepo: ImplRepo): Repositorio

    @Binds
    abstract fun DataSourceImplBind(dataSourceImpl: DataSourceImpl) : DataSource
}
