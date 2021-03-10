package com.android.example.krypto_analizer.network

data class CryptoResponseBase(
        val meta: Any,
        val payload: List<CryptoDataBase>)