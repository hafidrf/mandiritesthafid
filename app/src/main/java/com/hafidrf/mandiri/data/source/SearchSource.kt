package com.hafidrf.mandiri.data.source

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import io.reactivex.disposables.CompositeDisposable
import com.hafidrf.mandiri.data.model.news.DataNews
import com.hafidrf.mandiri.data.network.ApiService
import com.hafidrf.mandiri.data.state.NewsState
import javax.inject.Inject

/**
 * Created by : com.hafidrf.mandiri
 */

class SearchSource @Inject constructor(
    private val apiService: ApiService,
    private val disposable: CompositeDisposable
) : PageKeyedDataSource<Int, DataNews>() {

    lateinit var liveData : MutableLiveData<NewsState>
    lateinit var query : String

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, DataNews>
    ) {
        apiService.searchNews(query, 1)
            .map<NewsState>{
                callback.onResult(it.data, 1, 2)
                NewsState.Result(it)
            }
            .onErrorReturn(NewsState::Error)
            .toFlowable()
            .startWith(NewsState.Loading)
            .subscribe(liveData::postValue)
            .let { return@let disposable::add }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, DataNews>) {

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, DataNews>) {
        apiService.searchNews(query, params.key)
            .map<NewsState>{
                callback.onResult(it.data, params.key + 1)
                NewsState.Result(it)
            }
            .onErrorReturn(NewsState::Error)
            .toFlowable()
            .subscribe(liveData::postValue)
            .let { return@let disposable::add }
    }
}