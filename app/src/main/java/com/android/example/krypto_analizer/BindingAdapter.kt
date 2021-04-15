package com.android.example.krypto_analizer

import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.krypto_analizer.network.Asset
import com.android.example.krypto_analizer.overview.AssetIconAdapter
import com.android.example.krypto_analizer.overview.CoinApiStatus
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Asset>?) {
    val adapter = recyclerView.adapter as AssetIconAdapter
    adapter.submitList(data)
}

@BindingAdapter("price")
fun bindPrice(textView: TextView, asset: Asset) {
    val price = asset.priceUsd
    val priceDouble: Double? = price?.toDouble()
    if(priceDouble == null)
    {
        textView.text = "-"
    }
    else {
        textView.text = String.format("%.2f $", priceDouble)
    }
}

@BindingAdapter("cryptoApiStatus")
fun bindStatus(statusImageView: ImageView, status: CoinApiStatus?) {
    when (status) {
        CoinApiStatus.LOADING -> {
            statusImageView.visibility = View.VISIBLE
            statusImageView.setImageResource(R.drawable.sync_animation)
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

@BindingAdapter("icon")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
        Glide.with(imgView.context)
            .load(imgUri)
            .apply(RequestOptions()
                .placeholder(R.drawable.sync_animation)
                .error(R.drawable.ic_broken_image))
            .into(imgView)
    }
}