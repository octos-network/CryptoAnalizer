package com.android.example.krypto_analizer.network

import com.squareup.moshi.Json

data class Icon(
    @Json(name = "asset_id") val assetId : String,
    val url : String?)