package com.coolsharp.list.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.coolsharp.list.data.Product
import com.coolsharp.list.network.ApiService

class ProductsPagingSource(
    private val productApiService: ApiService,
    private val pageSize: Int = 20
) : PagingSource<Int, Product>() {

    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        return try {
            val page = params.key ?: 0
            val response = productApiService.getProducts(
                limit = pageSize,
                skip = page * pageSize
            )

            LoadResult.Page(
                data = response.products,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (response.products.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}