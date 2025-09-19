package com.coolsharp.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coolsharp.list.data.Categories
import com.coolsharp.list.data.CategoriesItem
import com.coolsharp.list.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryViewModel : ViewModel() {

    private val _categories = MutableStateFlow<List<CategoriesItem>>(emptyList())
    val categories: StateFlow<List<CategoriesItem>> = _categories

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.categoryApiService.getCategories()
                response.add(0, CategoriesItem("All", "", ""))
                _categories.value = response
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
