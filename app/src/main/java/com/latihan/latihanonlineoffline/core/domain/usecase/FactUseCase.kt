package com.latihan.latihanonlineoffline.core.domain.usecase

import com.latihan.latihanonlineoffline.core.data.Resource
import com.latihan.latihanonlineoffline.core.domain.model.Fact
import kotlinx.coroutines.flow.Flow

interface FactUseCase {
    suspend fun getFact(): Flow<Resource<List<Fact>>>
}