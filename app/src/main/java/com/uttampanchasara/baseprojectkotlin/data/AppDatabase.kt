package com.uttampanchasara.baseprojectkotlin.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.uttampanchasara.baseprojectkotlin.data.repository.Converters
import com.uttampanchasara.baseprojectkotlin.data.repository.headlines.Headlines
import com.uttampanchasara.baseprojectkotlin.data.repository.headlines.HeadlinesDao

/**
 *
 * @author <a href="https://github.com/UttamPanchasara">Uttam Panchasara</a>
 */
@Database(entities = [(Headlines::class)], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun headlinesDao(): HeadlinesDao
}