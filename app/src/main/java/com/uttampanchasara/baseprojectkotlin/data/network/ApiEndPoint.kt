package com.uttampanchasara.baseprojectkotlin.data.network

import com.uttampanchasara.baseprojectkotlin.BuildConfig

object ApiEndPoint {
    private const val BASE_URL = BuildConfig.BASE_URL
    const val GET_TOP_HEADLINES = BASE_URL + "top-headlines"

    internal interface KEYS {
        companion object {
            val COUNTRY = "country"
        }
    }
}// This class is not publicly instantiable