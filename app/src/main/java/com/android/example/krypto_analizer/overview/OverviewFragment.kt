package com.android.example.krypto_analizer.overview

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.android.example.krypto_analizer.R
import com.android.example.krypto_analizer.databinding.FragmentOverviewBinding
import com.android.example.krypto_analizer.network.CoinApiFilterAssetId

class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.assetAdapter.adapter = AssetAdapter(AssetAdapter.OnClickListener {})

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.updateFilter(
            when (item.itemId) {
                R.id.show_first_ten_crypto_menu -> CoinApiFilterAssetId.SHOW_BEST_TEN_CRYPTO
                else -> CoinApiFilterAssetId.SHOW_ALL
            }
        )
        return true
    }
}