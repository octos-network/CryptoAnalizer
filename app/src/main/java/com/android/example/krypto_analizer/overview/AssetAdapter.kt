package com.android.example.krypto_analizer.overview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.example.krypto_analizer.databinding.AssetViewBinding
import com.android.example.krypto_analizer.network.Asset

class AssetAdapter(val onClickListener: OnClickListener) :
        ListAdapter<Asset, AssetAdapter.AssetsViewHolder>(DiffCallback) {

    class AssetsViewHolder(private var binding: AssetViewBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(asset: Asset) {
            binding.asset = asset
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Asset>() {
        override fun areItemsTheSame(oldItem: Asset, newItem: Asset): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Asset, newItem: Asset): Boolean {
            return oldItem.assetId == newItem.assetId
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssetsViewHolder {
        return AssetsViewHolder(AssetViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: AssetsViewHolder, position: Int) {
        val asset = getItem(position)
        holder.itemView.setOnClickListener { onClickListener.onClick(asset)
        }
        holder.bind(asset)
    }

    class OnClickListener(val clickListener: (asset: Asset) -> Unit) {
        fun onClick(asset: Asset) = clickListener(asset)
    }
}