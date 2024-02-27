package com.hafidrf.mandiri.data.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.hafidrf.mandiri.data.model.news.DataNews
import com.hafidrf.mandiri.data.source.NewsSource
import com.hafidrf.mandiri.data.state.NewsState
import javax.inject.Inject

/**
 * Created by : com.hafidrf.mandiri
 */

class NewsFactory @Inject constructor(
    private val source: NewsSource
) : DataSource.Factory<Int, DataNews>() {

    lateinit var liveData : MutableLiveData<NewsState>
    var sources : String = ""

    override fun create(): DataSource<Int, DataNews> {
        return source.also {
            it.sources = sources
            it.liveData = liveData
        }
    }
}