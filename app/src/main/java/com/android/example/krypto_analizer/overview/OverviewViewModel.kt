package com.android.example.krypto_analizer.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.android.example.krypto_analizer.CryptoApi
import com.android.example.krypto_analizer.network.CryptoResponseBase
import com.android.example.krypto_analizer.network.CryptoResponseMeta

class OverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        //getCryptoAnalizerMeta()
        getCryptoAnalizerBase()
    }

    private fun getCryptoAnalizerMeta() {
        CryptoApi.retrofitService.getMeta().enqueue( object: Callback<CryptoResponseMeta> {
            override fun onFailure(call: Call<CryptoResponseMeta>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<CryptoResponseMeta>, response: Response<CryptoResponseMeta>) {
                _response.value = "Success: ${response.body()?.payload?.size} Crypto Coins loaded"
            }
        })
    }

    private fun getCryptoAnalizerBase() {
        CryptoApi.retrofitService.getBase().enqueue( object: Callback<CryptoResponseBase> {
            override fun onFailure(call: Call<CryptoResponseBase>, t: Throwable) {
                _response.value = "Failure " + t.message
            }

            override fun onResponse(call: Call<CryptoResponseBase>, response: Response<CryptoResponseBase>) {
                _response.value = "Success: ${response.body()?.payload?.size} Crypto Coins loaded"
            }
        })
    }
}