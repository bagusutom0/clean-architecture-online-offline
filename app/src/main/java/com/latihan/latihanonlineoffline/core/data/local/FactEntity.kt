package com.latihan.latihanonlineoffline.core.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.latihan.latihanonlineoffline.core.domain.model.Fact

@Entity(tableName = "fact")
data class FactEntity(
    @PrimaryKey
    val fact: String
)

fun FactEntity.toDomain() = Fact(fact)

fun Fact.toFactEntity() = FactEntity(fact)