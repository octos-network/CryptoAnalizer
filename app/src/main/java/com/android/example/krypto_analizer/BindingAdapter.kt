package com.android.example.krypto_analizer

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.krypto_analizer.network.Asset
import com.android.example.krypto_analizer.overview.AssetAdapter
import com.android.example.krypto_analizer.overview.CoinApiStatus

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Asset>?) {
    val adapter = recyclerView.adapter as AssetAdapter
    adapter.submitList(data)
}

@BindingAdapter("cryptoApiStatus")
fun bindStatus(statusImageView: ImageView, status: CoinApiStatus?) {
    when (status) {
        CoinApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.loading_animation)
        }
        CoinApiStatus.ERROR -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.ic_connection_error)
        }
        CoinApiStatus.DONE -> {
            statusImageView.visibility = View.GONE
        }
    }
}