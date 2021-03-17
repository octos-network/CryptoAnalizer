package com.android.example.krypto_analizer.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.krypto_analizer.databinding.ExchangesViewBinding
import com.android.example.krypto_analizer.network.Exchange

class ExchangeAdapter(val onClickListener: OnClickListener) :
        ListAdapter<Exchange, ExchangeAdapter.ExchangeViewHolder>(DiffCallback) {

    class ExchangeViewHolder(private var binding: ExchangesViewBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(exchange: Exchange) {
            binding.exchange = exchange
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Exchange>() {
        override fun areItemsTheSame(oldItem: Exchange, newItem: Exchange): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Exchange, newItem: Exchange): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExchangeViewHolder {
        return ExchangeViewHolder(ExchangesViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ExchangeViewHolder, position: Int) {
        val exchange = getItem(position)
        holder.itemView.setOnClickListener { onClickListener.onClick(exchange)
        }
        holder.bind(exchange)
    }

    class OnClickListener(val clickListener: (exchange:Exchange) -> Unit) {
        fun onClick(exchange: Exchange) = clickListener(exchange)
    }
}