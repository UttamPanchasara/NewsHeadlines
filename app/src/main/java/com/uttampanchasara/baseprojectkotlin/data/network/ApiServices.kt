package com.uttampanchasara.baseprojectkotlin.data.network

import android.content.Context

import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.uttampanchasara.baseprojectkotlin.BuildConfig
import com.uttampanchasara.baseprojectkotlin.R
import com.uttampanchasara.baseprojectkotlin.isConnected

import java.io.IOException

import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class ApiServices private constructor() {

    fun initService(context: Context) {

        val client = OkHttpClient().newBuilder()
        client.interceptors().add(Interceptor { chain ->
            if (isConnected(context)) {
                var request = chain.request()
                val url = request.url().newBuilder().addQueryParameter("apiKey", BuildConfig.API_KEY).build()
                request = request.newBuilder().url(url).build()
                chain.proceed(request)
            } else {
                throw ANError(context.getString(R.string.internet_error))
            }
        })

        AndroidNetworking.initialize(context, client.build())
    }

    companion object {
        val instance = ApiServices()
    }
}