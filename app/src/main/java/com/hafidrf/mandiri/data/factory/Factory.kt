package com.hafidrf.mandiri.data.factory

import javax.inject.Inject

/**
 * Created by : com.hafidrf.mandiri
 */

data class Factory @Inject constructor(
    val newsFactory : NewsFactory,
    val searchFactory : SearchFactory
)
