package com.example.data.model

import com.squareup.moshi.Json

data class Repository(
    @field:Json(name = "id") val id: Int,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "full_name") val full_name: String,
    @field:Json(name = "html_url") val html_url: String,
    @field:Json(name = "description") val description: String? = null,
    @field:Json(name = "open_issues_count") val open_issues_count: Int,
)
