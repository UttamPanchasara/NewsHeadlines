package com.uttampanchasara.baseprojectkotlin.data.repository

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.uttampanchasara.baseprojectkotlin.data.repository.headlines.Source


class Converters {
    @TypeConverter
    fun fromSource(content: Source?): String? {
        return Gson().toJson(content)
    }

    @TypeConverter
    fun toSource(content: String?): Source? {
        return Gson().fromJson(content, Source::class.java)
    }
}