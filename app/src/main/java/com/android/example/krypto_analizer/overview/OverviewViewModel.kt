package com.android.example.krypto_analizer.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.krypto_analizer.network.CryptoApi
import com.android.example.krypto_analizer.network.CryptoDataBase
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _base = MutableLiveData<CryptoDataBase>()

    val base: LiveData<CryptoDataBase>
        get() = _base

    init {
        getCryptoAnalizerBase()
    }

    private fun getCryptoAnalizerBase() {
       viewModelScope.launch {
           try {
               val listResult = CryptoApi.retrofitService.getBase().body()!!.payload
               _status.value = "Success: ${listResult.size} Crypto Coins loaded"
               Log.d("API_Service", _status.value!!)
               if (listResult.size > 0) {
                   _base.value = listResult[0]
               }
           } catch (e: Exception) {
               _status.value = "Failure: ${e.message}"
               Log.d("API_Service", _status.value!!)
           }
       }
    }
}