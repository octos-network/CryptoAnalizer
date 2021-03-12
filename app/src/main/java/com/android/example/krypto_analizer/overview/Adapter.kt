package com.android.example.krypto_analizer.overview

import android.view.View
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.krypto_analizer.databinding.ExchangesViewBinding
import com.android.example.krypto_analizer.network.Exchange

class Adapter(val onClickListener: View.OnClickListener) :
        ListAdapter<Exchange, Adapter.CryptoCoinViewHolder>(DiffCallback) {

    class CryptoCoinViewHolder(private var binding: ExchangesViewBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(exchange: Exchange) {
            binding.exchanges = exchange
            binding.executePendingBindings()
        }
    }
}