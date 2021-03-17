package com.android.example.krypto_analizer

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.krypto_analizer.network.Exchange
import com.android.example.krypto_analizer.overview.ExchangeAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Exchange>?) {
    val adapter = recyclerView.adapter as ExchangeAdapter
    adapter.submitList(data)
}