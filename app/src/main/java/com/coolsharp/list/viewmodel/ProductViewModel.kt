package com.coolsharp.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.coolsharp.list.data.Products
import com.coolsharp.list.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val category: String) : ViewModel() {
    private val repository = ProductRepository()

    val products = repository.getProducts(category = category).cachedIn(viewModelScope)
}