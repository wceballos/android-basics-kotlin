package com.example.android.marsphotos.network

import com.squareup.moshi.Json

/**
 * This data class defines a Mars photo. The properties are used by Moshi to
 * match the JSON values.
 */
data class MarsPhoto(
    @Json(name = "id") val id: String,
    @Json(name = "img_src") val imgSrcUrl: String
)
