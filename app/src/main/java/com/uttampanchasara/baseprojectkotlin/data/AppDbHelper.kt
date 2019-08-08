package com.uttampanchasara.baseprojectkotlin.data

import com.uttampanchasara.baseprojectkotlin.data.repository.headlines.Headlines
import io.reactivex.Observable
import javax.inject.Inject

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 * @since 11/15/2018
 */
class AppDbHelper @Inject internal constructor(private val appDatabase: AppDatabase) : DbHelper {
    override fun deleteHeadlines(): Observable<Boolean> {
        return Observable.fromCallable {
            appDatabase.headlinesDao().deleteAll()
            return@fromCallable true
        }
    }

    override fun getHeadlines(): Observable<List<Headlines>> {
        return Observable.fromCallable {
            return@fromCallable appDatabase.headlinesDao().getHeadlines()
        }
    }

    override fun insertHeadlines(headlines: List<Headlines>): Observable<Boolean> {
        return Observable.fromCallable {
            appDatabase.headlinesDao().insert(headlines)
            return@fromCallable true
        }
    }
}