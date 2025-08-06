package com.coolsharp.list.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.coolsharp.list.data.Products
import com.coolsharp.list.network.RetrofitInstance

class ProductRepository {
    private val productApiService = RetrofitInstance.apiService

    fun getProducts(pageSize: Int = 20) = Pager(
        config = PagingConfig(
            pageSize = pageSize,
            enablePlaceholders = false,
            initialLoadSize = pageSize * 2
        ),
        pagingSourceFactory = {
            ProductsPagingSource(productApiService, pageSize)
        }
    ).flow
}