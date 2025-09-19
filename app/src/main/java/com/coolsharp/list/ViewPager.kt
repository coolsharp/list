package com.coolsharp.list

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.coolsharp.list.viewmodel.CategoryViewModel
import com.coolsharp.list.viewmodel.ProductViewModel
import kotlinx.coroutines.launch

@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun CategoryScreen(
    viewModel: CategoryViewModel = viewModel()
) {
    val categories by viewModel.categories.collectAsState()
    val pagerState = rememberPagerState(
        pageCount = { viewModel.categories.value.size }
    )
    val coroutineScope = rememberCoroutineScope()

    Column {
        if (categories.isNotEmpty()) {
            ScrollableTabRow(
                selectedTabIndex = pagerState.currentPage,
                edgePadding = 8.dp
            ) {
                categories.forEachIndexed { index, category ->
                    Tab(
                        text = { Text(category.name) },
                        selected = pagerState.currentPage == index,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                    )
                }
            }

            val viewModelCache = remember { mutableMapOf<String, ProductViewModel>() }

            HorizontalPager(
                beyondViewportPageCount = 3,
                state = pagerState,
                modifier = Modifier.fillMaxSize()
            ) { page ->
                val viewModel = viewModelCache.getOrPut(categories[page].slug) {
                    ProductViewModel(categories[page].slug)
                }
                ProductScreen(viewModel)
            }
        } else {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
    }
}
