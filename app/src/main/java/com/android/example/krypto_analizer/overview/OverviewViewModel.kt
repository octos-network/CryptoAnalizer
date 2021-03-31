package com.android.example.krypto_analizer.overview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.example.krypto_analizer.network.Asset
import com.android.example.krypto_analizer.network.CoinApi
import com.android.example.krypto_analizer.network.CoinApiFilterAssetId
import com.android.example.krypto_analizer.network.Icon
import kotlinx.coroutines.launch

enum class CoinApiStatus { LOADING, ERROR, DONE}

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<CoinApiStatus>()

    val status: LiveData<CoinApiStatus>
        get() = _status

    private val _assets = MutableLiveData<List<Asset>>()

    val assets: LiveData<List<Asset>>
        get() = _assets

    private val _icons = MutableLiveData<List<Icon>>()

    val icons: LiveData<List<Icon>>
        get() = _icons

    private val _navigateToSelectedAsset = MutableLiveData<Asset>()

    val navigateToSelectedAsset: LiveData<Asset>
        get() = _navigateToSelectedAsset

    init {
        getAssets(CoinApiFilterAssetId.SHOW_ALL)
        getIcons()
    }

    private fun getAssets(filter: CoinApiFilterAssetId) {
       viewModelScope.launch {
           _status.value = CoinApiStatus.LOADING
           try {
               _assets.value = CoinApi.retrofitServiceAssets.getAssets(filter.value)
               _status.value = CoinApiStatus.DONE
           } catch (e: Exception) {
               _status.value = CoinApiStatus.ERROR
               _assets.value = ArrayList()
               Log.d("coin_asset", e.message.toString())
           }
       }
    }

    private fun getIcons() {
        viewModelScope.launch {
            try {
                _icons.value = CoinApi.retrofitServiceIcons.getIcons()
            } catch (e: Exception) {
                _icons.value = ArrayList()
                Log.d("coin_icons", e.message.toString())
            }
        }
    }

    fun updateFilter(filter: CoinApiFilterAssetId) {
        getAssets(filter)
    }
}