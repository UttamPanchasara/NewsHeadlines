package com.uttampanchasara.baseprojectkotlin.data.repository.headlines

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import android.support.annotation.NonNull
import com.uttampanchasara.baseprojectkotlin.data.repository.Converters

@Entity(tableName = "headlines")
data class Headlines(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val author: String?,
        val content: String?,
        val description: String?,
        val publishedAt: String?,
        @TypeConverters(Converters::class)
        val source: Source?,
        val title: String?,
        val url: String?,
        val urlToImage: String?
)