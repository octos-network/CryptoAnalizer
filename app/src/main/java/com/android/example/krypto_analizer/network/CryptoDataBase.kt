package com.android.example.krypto_analizer.network

data class CryptoDataBase(
    val exchangeId: String,
    val name: String,
    val website: String,
    val logo: String,
    val volume: String,
    val change: String,
    val markets: String,
    val takerFee: String,
    val makerFee: String,
    val _id: String)