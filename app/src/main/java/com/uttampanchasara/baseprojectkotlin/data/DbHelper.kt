package com.uttampanchasara.baseprojectkotlin.data

import com.uttampanchasara.baseprojectkotlin.data.repository.headlines.Headlines
import io.reactivex.Observable

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 * @since 11/15/2018
 */
interface DbHelper {
    fun insertHeadlines(headlines: List<Headlines>): Observable<Boolean>

    fun deleteHeadlines(): Observable<Boolean>

    fun getHeadlines(): Observable<List<Headlines>>
}