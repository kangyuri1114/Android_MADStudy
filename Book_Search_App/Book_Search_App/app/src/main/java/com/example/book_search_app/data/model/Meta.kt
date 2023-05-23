package com.example.book_search_app.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Meta(
    @field:Json(name = "is_end") //Json 만으로는 코틀린에서 변환에 실패하므로 field:를 붙인다.
    val isEnd: Boolean, // false
    @field:Json(name = "pageable_count")
    val pageableCount: Int, // 1000
    @field:Json(name = "total_count")
    val totalCount: Int // 1075
)
