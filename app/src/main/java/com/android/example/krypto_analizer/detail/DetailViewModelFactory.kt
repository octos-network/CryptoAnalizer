package com.android.example.krypto_analizer.detail

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

//class DetailViewModelFactory(
//        private val cryptoProperty: CryptoProperty,
//        private val application: Application) : ViewModelProvider.Factory {
//    @Suppress("unchecked_cast")
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
//            return DetailViewModel(cryptoProperty, application) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel class")
//    }
//}