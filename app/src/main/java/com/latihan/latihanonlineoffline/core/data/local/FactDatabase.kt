package com.latihan.latihanonlineoffline.core.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import javax.inject.Singleton

@Singleton
@Database(entities = [FactEntity::class], version = 1)
abstract class FactDatabase: RoomDatabase() {
    abstract fun factDao(): FactDao
}