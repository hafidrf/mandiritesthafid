package com.hafidrf.mandiri.data.model.news

import com.google.gson.annotations.SerializedName

/**
 * Created by : com.hafidrf.mandiri
 */

data class ResponseNews(
        @SerializedName("status")
        val status: String = "",

        @SerializedName("totalResults")
        val totalResults: Int = 0,

        @SerializedName("articles")
        val data: List<DataNews> = emptyList()
)
