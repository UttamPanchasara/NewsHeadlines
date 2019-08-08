package com.uttampanchasara.baseprojectkotlin.data.repository.headlines

data class Articles(
        val status: String,
        val totalResults: Int,
        val articles: List<Headlines>
)