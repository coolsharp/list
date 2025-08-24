package com.coolsharp.list.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.coolsharp.list.network.RetrofitInstance

class ProductRepository {
    private val productApiService = RetrofitInstance.productsApiService

    fun getProducts(pageSize: Int = 20) = Pager(
        pagingSourceFactory = {
            ProductsPagingSource(productApiService, pageSize)
        },
        config = PagingConfig(
            pageSize = pageSize,
            enablePlaceholders = false,
            initialLoadSize = pageSize * 2
        )
    ).flow
}