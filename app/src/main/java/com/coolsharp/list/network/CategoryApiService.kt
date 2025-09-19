package com.coolsharp.list.network

import com.coolsharp.list.data.Categories
import com.coolsharp.list.data.CategoriesItem
import retrofit2.http.GET

interface CategoryApiService {
    @GET("products/categories")
    suspend fun getCategories(): ArrayList<CategoriesItem>
}