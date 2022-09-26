package com.latihan.latihanonlineoffline.core.domain.repository

import com.latihan.latihanonlineoffline.core.data.Resource
import com.latihan.latihanonlineoffline.core.domain.model.Fact
import kotlinx.coroutines.flow.Flow

interface FactRepository {
    suspend fun getFact(): Flow<Resource<List<Fact>>>
}