package com.example.book_search_app.data.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponse(
    val documents: List<Book>,
    val meta: Meta
)
