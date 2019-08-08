package com.uttampanchasara.baseprojectkotlin.data

import android.content.Context
import com.uttampanchasara.baseprojectkotlin.data.network.ApiHelper
import com.uttampanchasara.baseprojectkotlin.data.prefs.PreferencesHelper
import com.uttampanchasara.baseprojectkotlin.data.repository.headlines.Articles
import com.uttampanchasara.baseprojectkotlin.data.repository.headlines.Headlines
import com.uttampanchasara.baseprojectkotlin.di.ApplicationContext
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 */
@Singleton
class AppDataManager
@Inject internal constructor(@ApplicationContext val context: Context,
                             private val dbHelper: DbHelper,
                             private val preferencesHelper: PreferencesHelper,
                             private val apiHelper: ApiHelper) : DataManager {
    override fun deleteHeadlines(): Observable<Boolean> {
        return dbHelper.deleteHeadlines()
    }

    override fun getHeadlines(): Observable<List<Headlines>> {
        return dbHelper.getHeadlines()
    }

    override fun insertHeadlines(headlines: List<Headlines>): Observable<Boolean> {
        return dbHelper.insertHeadlines(headlines)
    }

    override fun getHeadlines(country: String): Observable<Articles> {
        return apiHelper.getHeadlines(country)
    }

    override fun setAccessToken(accessToken: String?) {
        preferencesHelper.accessToken = accessToken
    }

    override fun getAccessToken(): String {
        return preferencesHelper.accessToken
    }
}