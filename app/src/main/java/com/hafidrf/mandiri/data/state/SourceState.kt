package com.hafidrf.mandiri.data.state

import com.hafidrf.mandiri.data.model.source.ResponseSource

/**
 * Created by : com.hafidrf.mandiri
 */

sealed class SourceState {
    object Loading : SourceState()
    data class Result(val data : ResponseSource) : SourceState()
    data class Error(val error : Throwable) : SourceState()
}
