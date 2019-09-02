package com.abuzar.sampleapplication.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by ABUZAR on 9/1/2019.
 */

data class ApiResponse<out T>(
    @SerializedName("total")
    val total: Int,
    @SerializedName("data")
    val dataList: List<T>
)