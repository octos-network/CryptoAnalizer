package com.android.example.krypto_analizer.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.krypto_analizer.network.CryptoApi
import com.android.example.krypto_analizer.network.Exchange
import kotlinx.coroutines.launch

enum class CryptoApiStatus { LOADING, ERROR, DONE}

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<CryptoApiStatus>()

    val status: LiveData<CryptoApiStatus>
        get() = _status

    private val _exchanges = MutableLiveData<List<Exchange>>()

    val exchanges: LiveData<List<Exchange>>
        get() = _exchanges

    private val _navigateToSelectedProperty = MutableLiveData<Exchange>()

    val navigateToSelectedProperty: LiveData<Exchange>
        get() = _navigateToSelectedProperty

    init {
        getExchanges()
    }

    private fun getExchanges() {
       viewModelScope.launch {
           _status.value = CryptoApiStatus.LOADING
           try {
               _exchanges.value = CryptoApi.retrofitService.getExchanges().body()!!.payload
               _status.value = CryptoApiStatus.DONE
           } catch (e: Exception) {
               _status.value = CryptoApiStatus.ERROR
               _exchanges.value = ArrayList()
               Log.d("crypto_exchange", e.message.toString())
           }
       }
    }
}