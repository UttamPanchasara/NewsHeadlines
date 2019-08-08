package com.uttampanchasara.baseprojectkotlin.data.network

import com.rx2androidnetworking.Rx2AndroidNetworking
import com.uttampanchasara.baseprojectkotlin.data.repository.headlines.Articles
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppApiHelper @Inject
constructor(private val mApiHeader: ApiHeader) : ApiHelper {

    override fun getHeadlines(country: String): Observable<Articles> {
        return Rx2AndroidNetworking.get(ApiEndPoint.GET_TOP_HEADLINES)
                .addQueryParameter(ApiEndPoint.KEYS.COUNTRY, country)
                .build()
                .getObjectObservable(Articles::class.java)
    }
}