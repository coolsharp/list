package com.coolsharp.list.network

import com.coolsharp.list.data.Products
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/products")
    suspend fun getProducts(
        @Query("limit") limit: Int = 10,
        @Query("skip") skip: Int = 0,
        @Query("delay") delay: Int = 0
    ): Products
}