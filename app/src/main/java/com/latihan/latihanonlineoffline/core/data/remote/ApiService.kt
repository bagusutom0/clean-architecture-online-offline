package com.latihan.latihanonlineoffline.core.data.remote

import retrofit2.http.GET

interface ApiService {
    @GET("facts")
    suspend fun getFact(): FactResponse
}