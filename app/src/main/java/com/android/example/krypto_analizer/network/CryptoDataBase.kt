package com.android.example.krypto_analizer.network

import com.squareup.moshi.Json

data class CryptoDataBase(
        @Json(name = "_id") val id: String,
        val exchangeId: String,
        val name: String,
        val website: String,
        val logo: Logo?,
        val volume: String,
        val change: String,
        val markets: String,
        val takerFee: String,
        val makerFee: String)