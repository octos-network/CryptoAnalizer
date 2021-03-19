package com.android.example.krypto_analizer.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

private const val BASE_URL = "https://rest.coinapi.io"
enum class CoinApiFilter(val value: String) { SHOW_ALL(""), SHOW_FIRST_TEN("BTC,NIS,LTC,VEN,XRP,NMC,USDT,BLC,DOGE,NVC")}

private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

private val loggingInterceptor = run {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.apply {
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    }
}

private val okHttpClient = OkHttpClient.Builder()
        .addNetworkInterceptor(loggingInterceptor)
        .build()

private val retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

interface CoinApiService {
    @Headers("X-CoinAPI-Key: 6FCAC8F0-6B80-4761-803C-2E4C11A0BA0C")
    @GET("/v1/assets")
    suspend fun getAssets(@Query("filter_asset_id") type: String): List<Asset>
}

object CoinApi {
    val retrofitService: CoinApiService by lazy { retrofit.create(CoinApiService::class.java) }
}