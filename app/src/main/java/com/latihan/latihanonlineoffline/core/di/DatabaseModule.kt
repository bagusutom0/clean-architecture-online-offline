package com.latihan.latihanonlineoffline.core.di

import android.content.Context
import androidx.room.Room
import com.latihan.latihanonlineoffline.core.data.local.FactDao
import com.latihan.latihanonlineoffline.core.data.local.FactDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideFactDatabase(@ApplicationContext context: Context): FactDatabase {
        return Room.databaseBuilder(
            context,
            FactDatabase::class.java,
            "Fact.db"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideFactDao(database: FactDatabase): FactDao = database.factDao()
}