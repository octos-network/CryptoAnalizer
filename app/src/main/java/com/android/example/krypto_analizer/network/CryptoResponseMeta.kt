package com.android.example.krypto_analizer.network

data class CryptoResponseMeta(
    val meta: Any,
    val payload: List<CryptoDataMeta>)