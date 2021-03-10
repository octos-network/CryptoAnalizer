package com.android.example.krypto_analizer

import com.android.example.krypto_analizer.network.CryptoDataMeta
import com.android.example.krypto_analizer.network.CryptoResponseBase
import com.android.example.krypto_analizer.network.CryptoResponseMeta
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL = "https://api.cryptoapis.io"

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
        //.addConverterFactory(ScalarsConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

interface CryptoApiService {
     @Headers("X-API-Key: 4a7f07327d40ad33486b5446566e4398510f4c95")
     @GET("/v1/exchanges/meta")
    suspend fun getMeta(): Response<CryptoResponseMeta>

    @Headers("X-API-Key: 32acf8474237ba06318177f4772dd6f0a148831e")
    @GET("/v1/exchanges")
    suspend fun getBase(): Response<CryptoResponseBase>
}


object CryptoApi {
    val retrofitService: CryptoApiService by lazy { retrofit.create(CryptoApiService::class.java) }
}


// "Content-Type: application/json",
//        "X-API-Key: 4a7f07327d40ad33486b5446566e4398510f4c95"
//         .addHeader("Content-Type", "application/json")
//        .addHeader("X-API-Key", "4a7f07327d40ad33486b5446566e4398510f4c95")