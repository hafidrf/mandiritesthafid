package com.hafidrf.mandiri.data.repository

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import io.reactivex.disposables.CompositeDisposable
import com.hafidrf.mandiri.data.model.categories.Categories
import com.hafidrf.mandiri.data.model.news.DataNews
import com.hafidrf.mandiri.data.state.NewsState
import com.hafidrf.mandiri.data.state.SourceState

/**
 * Created by : com.hafidrf.mandiri
 */

interface Repository {

    fun getHeadlines(
        callback: MutableLiveData<NewsState>
    )

    fun getSources(
        categories: String,
        callback : MutableLiveData<SourceState>
    )

    fun getNews(
        sources : String,
        callback: MutableLiveData<NewsState>,
        data: MutableLiveData<PagedList<DataNews>>,
        lifecycleOwner: LifecycleOwner
    )

    fun searchNews(
        query : String,
        callback: MutableLiveData<NewsState>,
        data: MutableLiveData<PagedList<DataNews>>,
        lifecycleOwner: LifecycleOwner
    )

    fun getCategories(context : Context) : List<Categories>

    fun getDisposable() : CompositeDisposable
}