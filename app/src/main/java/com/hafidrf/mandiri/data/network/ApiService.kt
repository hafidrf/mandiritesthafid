package com.hafidrf.mandiri.data.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import com.hafidrf.mandiri.data.model.news.ResponseNews
import com.hafidrf.mandiri.data.model.source.ResponseSource

/**
 * Created by : com.hafidrf.mandiri
 */

interface ApiService {

    @GET("top-headlines?country=us")
    fun getHeadline(): Single<ResponseNews>

    @GET("sources")
    fun getSource(
            @Query("category") category: String?
    ): Single<ResponseSource>

    @GET("top-headlines")
    fun getNews(
        @Query("sources") sources: String?,
        @Query("page") page: Int,
    ): Single<ResponseNews>

    @GET("everything")
    fun searchNews(
        @Query("q") keyword: String?,
        @Query("page") page: Int,
    ): Single<ResponseNews>
}