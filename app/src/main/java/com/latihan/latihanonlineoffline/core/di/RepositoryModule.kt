package com.latihan.latihanonlineoffline.core.di

import com.latihan.latihanonlineoffline.core.data.FactRepositoryImpl
import com.latihan.latihanonlineoffline.core.domain.repository.FactRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun provideFactRepository(factRepositoryImpl: FactRepositoryImpl): FactRepository
}