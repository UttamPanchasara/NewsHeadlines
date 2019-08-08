package com.uttampanchasara.baseprojectkotlin.data.repository.headlines

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 */
@Dao
interface HeadlinesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(headlines: List<Headlines>)

    @Query("SELECT * FROM headlines order by publishedAt desc")
    fun getHeadlines(): List<Headlines>

    @Query("DELETE FROM headlines")
    fun deleteAll()
}