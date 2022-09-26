package com.latihan.latihanonlineoffline.di

import com.latihan.latihanonlineoffline.core.domain.usecase.FactInteractor
import com.latihan.latihanonlineoffline.core.domain.usecase.FactUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class AppModule {
    @Binds
    @ViewModelScoped
    abstract fun provideFactUseCase(factInteractor: FactInteractor): FactUseCase
}