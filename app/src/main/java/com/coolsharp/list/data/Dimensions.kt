package com.coolsharp.list.data


import android.annotation.SuppressLint
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SuppressLint("UnsafeOptInUsageError")
@Serializable
data class Dimensions(
    @SerialName("depth")
    val depth: Double,
    @SerialName("height")
    val height: Double,
    @SerialName("width")
    val width: Double
)