package com.android.example.krypto_analizer.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.krypto_analizer.CryptoApi
import com.android.example.krypto_analizer.network.CryptoDataBase
import com.android.example.krypto_analizer.network.CryptoDataMeta
import com.android.example.krypto_analizer.network.CryptoResponseBase
import com.android.example.krypto_analizer.network.CryptoResponseMeta
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<String>()

    val status: LiveData<String>
        get() = _status

    private val _meta = MutableLiveData<CryptoDataMeta>()

    val meta: LiveData<CryptoDataMeta>
        get() = _meta

    private val _base = MutableLiveData<CryptoDataBase>()

    val base: LiveData<CryptoDataBase>
        get() = _base

    init {
        getCryptoAnalizerMeta()
        //getCryptoAnalizerBase()
    }

    private fun getCryptoAnalizerMeta() {
        viewModelScope.launch {
            try {
                val listResult = CryptoApi.retrofitService.getMeta().body()!!.payload
                _status.value = "Success: ${listResult.size} Crypto Coins loaded"
                if (listResult.size > 0) {
                    _meta.value = listResult[0]
                }
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

    private fun getCryptoAnalizerBase() {
       viewModelScope.launch {
           try {
               val listResult = CryptoApi.retrofitService.getBase().body()!!.payload
               _status.value = "Success: ${listResult.size} Crypto Coins loaded"
               if (listResult.size > 0) {
                   _base.value = listResult[0]
               }
           } catch (e: Exception) {
               _status.value = "Failure: ${e.message}"
           }
       }
    }
}

//             android:text="@{viewModel.meta.payload}"