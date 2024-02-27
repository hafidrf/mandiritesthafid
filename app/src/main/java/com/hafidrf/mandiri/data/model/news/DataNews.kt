package com.hafidrf.mandiri.data.model.news

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

/**
 * Created by : com.hafidrf.mandiri
 */

@Parcelize
data class DataNews(
    @SerializedName("source")
    var modelSource: Source?,

    @SerializedName("author")
    var author: String? = "",

    @SerializedName("title")
    var title: String? = "",

    @SerializedName("description")
    var description: String? = "",

    @SerializedName("url")
    var url: String? = "",

    @SerializedName("urlToImage")
    var urlToImage: String? = "",

    @SerializedName("publishedAt")
    var publishedAt: String? = "",

    @SerializedName("content")
    var content: String? = ""

) : Parcelable
