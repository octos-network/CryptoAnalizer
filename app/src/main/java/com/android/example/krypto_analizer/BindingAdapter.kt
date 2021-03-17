package com.android.example.krypto_analizer

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.krypto_analizer.network.Exchange
import com.android.example.krypto_analizer.overview.CryptoApiStatus
import com.android.example.krypto_analizer.overview.ExchangeAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Exchange>?) {
    val adapter = recyclerView.adapter as ExchangeAdapter
    adapter.submitList(data)
}

@BindingAdapter("cryptoApiStatus")
fun bindStatus(statusImageView: ImageView, status: CryptoApiStatus?) {
    when (status) {
        CryptoApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        CryptoApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        CryptoApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}