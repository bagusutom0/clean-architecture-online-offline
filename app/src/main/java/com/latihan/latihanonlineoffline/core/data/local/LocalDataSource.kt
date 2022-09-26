package com.latihan.latihanonlineoffline.core.data.local

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(private val factDao: FactDao){
    fun getFact(): Flow<List<FactEntity>> = factDao.getFact()

    suspend fun insertFact(fact: List<FactEntity>) = factDao.insertFact(fact)
}