package com.coolsharp.list.data


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CategoriesItem(
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("url")
    val url: String
)