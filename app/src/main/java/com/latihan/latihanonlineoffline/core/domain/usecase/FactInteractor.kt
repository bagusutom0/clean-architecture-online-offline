package com.latihan.latihanonlineoffline.core.domain.usecase

import com.latihan.latihanonlineoffline.core.data.Resource
import com.latihan.latihanonlineoffline.core.domain.model.Fact
import com.latihan.latihanonlineoffline.core.domain.repository.FactRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FactInteractor @Inject constructor(private val factRepository: FactRepository): FactUseCase {
    override suspend fun getFact(): Flow<Resource<List<Fact>>> = factRepository.getFact()
}