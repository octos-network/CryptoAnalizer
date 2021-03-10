package com.android.example.krypto_analizer.network

import com.squareup.moshi.Json

data class CryptoDataMeta (
        val exchangeId: String,
        val name: String,
        @Json(name = "_id") val coinId: String)