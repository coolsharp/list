package com.coolsharp.list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

sealed class ListItem {
    data class Header(val title: String) : ListItem()
    data class Content(val text: String) : ListItem()
}

@Composable
fun MultiTypeList(modifier: Modifier) {
    val items = listOf(
        ListItem.Header("Section 1"),
        ListItem.Content("Item 1"),
        ListItem.Content("Item 2"),
        ListItem.Header("Section 2"),
        ListItem.Content("Item 3"),
        ListItem.Content("Item 4")
    )

    LazyColumn(modifier = modifier) {
        itemsIndexed(items) { index, item ->
            when (item) {
                is ListItem.Header -> {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.headlineSmall,
                        modifier = Modifier.padding(16.dp)
                    )
                }
                is ListItem.Content -> {
                    Text(
                        text = item.text,
                        modifier = Modifier.padding(16.dp)
                    )
                    if (index < items.size - 1 && items[index + 1] is ListItem.Content) {
                        Divider(modifier = Modifier.padding(horizontal = 16.dp))
                    }
                }
            }
        }
    }
}