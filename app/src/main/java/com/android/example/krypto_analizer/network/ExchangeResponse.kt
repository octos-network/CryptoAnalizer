package com.android.example.krypto_analizer.network

data class ExchangeResponse(
        val meta: Any,
        val payload: List<Exchange>)