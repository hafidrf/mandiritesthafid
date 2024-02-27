package com.hafidrf.mandiri.utils

import android.content.Context

/**
 * Created by : com.hafidrf.mandiri
 */
object Extentions {

    fun Context.loadJSONFromAssets(fileName: String): String {
        return applicationContext.assets.open(fileName).bufferedReader().use { reader ->
            reader.readText()
        }
    }
}