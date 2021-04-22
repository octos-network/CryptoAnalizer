package com.android.example.krypto_analizer.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.example.krypto_analizer.network.Asset

class DetailViewModel(asset: Asset, app: Application) : AndroidViewModel(app) {
    private val _selectedAsset = MutableLiveData<Asset>()

    val selectedAsset: LiveData<Asset>
        get() = _selectedAsset

    init {
        _selectedAsset.value = asset
    }
}