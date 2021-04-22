package com.android.example.krypto_analizer.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.android.example.krypto_analizer.network.Asset
import java.lang.IllegalArgumentException

class DetailViewModelFactory(
    private val asset: Asset,
    private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(asset, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}