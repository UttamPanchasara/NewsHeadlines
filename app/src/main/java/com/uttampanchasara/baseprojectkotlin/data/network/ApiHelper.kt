package com.uttampanchasara.baseprojectkotlin.data.network

import com.uttampanchasara.baseprojectkotlin.data.repository.headlines.Articles
import io.reactivex.Observable

interface ApiHelper {
    fun getHeadlines(country: String): Observable<Articles>
}