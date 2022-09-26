package com.latihan.latihanonlineoffline.core.data

import com.latihan.latihanonlineoffline.core.data.local.LocalDataSource
import com.latihan.latihanonlineoffline.core.data.local.toDomain
import com.latihan.latihanonlineoffline.core.data.remote.ApiResponse
import com.latihan.latihanonlineoffline.core.data.remote.FactResponse
import com.latihan.latihanonlineoffline.core.data.remote.RemoteDataSource
import com.latihan.latihanonlineoffline.core.data.remote.toFactEntity
import com.latihan.latihanonlineoffline.core.domain.model.Fact
import com.latihan.latihanonlineoffline.core.domain.repository.FactRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FactRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): FactRepository {
    override suspend fun getFact(): Flow<Resource<List<Fact>>> {
        return object : NetworkBoundResource<List<Fact>, FactResponse>() {
            override suspend fun saveCallResult(data: FactResponse) {
                localDataSource.insertFact(data.data.map { it.toFactEntity()})
            }

            override suspend fun createCall(): Flow<ApiResponse<FactResponse>> {
                return remoteDataSource.getFact()
            }

            override fun shouldFetch(data: List<Fact>?): Boolean = data == null || data.isEmpty()

            override fun loadFromDb(): Flow<List<Fact>> {
                return localDataSource.getFact().map { it.map { it.toDomain() } }
            }
        }.asFlow()
    }

}