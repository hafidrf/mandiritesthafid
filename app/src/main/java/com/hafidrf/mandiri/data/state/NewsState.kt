package com.hafidrf.mandiri.data.state

import com.hafidrf.mandiri.data.model.news.ResponseNews

/**
 * Created by : com.hafidrf.mandiri
 */

sealed class NewsState {
    object Loading : NewsState()
    data class Result(val data : ResponseNews) : NewsState()
    data class Error(val error : Throwable) : NewsState()
}
