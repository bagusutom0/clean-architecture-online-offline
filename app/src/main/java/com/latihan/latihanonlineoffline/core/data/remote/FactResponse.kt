package com.latihan.latihanonlineoffline.core.data.remote

import com.google.gson.annotations.SerializedName
import com.latihan.latihanonlineoffline.core.data.local.FactEntity
import com.latihan.latihanonlineoffline.core.domain.model.Fact

data class FactResponse(

	@field:SerializedName("data")
	val data: List<FactDto>,

	@field:SerializedName("current_page")
	val currentPage: Int
)

data class FactDto(

	@field:SerializedName("fact")
	val fact: String,

	@field:SerializedName("length")
	val length: Int
)

fun FactDto.toDomain() = Fact(fact)

fun FactDto.toFactEntity(): FactEntity = FactEntity(fact)