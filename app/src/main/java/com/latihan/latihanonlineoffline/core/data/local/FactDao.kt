package com.latihan.latihanonlineoffline.core.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface FactDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFact(fact: List<FactEntity>)

    @Query("SELECT * FROM fact")
    fun getFact(): Flow<List<FactEntity>>
}