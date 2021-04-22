package com.android.example.krypto_analizer.network

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Asset(
    @Json(name = "asset_id") val assetId : String,
    val name: String?,
    @Json(name= "type_is_crypto") val typeIsCrypto: String,
    @Json(name = "data_start") val dataStart: String?,
    @Json(name = "data_end") val dataEnd: String?,
    @Json(name = "data_quote_start") val dataQuoteStart: String?,
    @Json(name = "data_quote_end") val dataQuoteEnd: String?,
    @Json(name = "data_orderbook_start") val dataOrderbookStart: String?,
    @Json(name = "data_orderbook_end") val dataOrderbookEnd: String?,
    @Json(name = "data_trade_start") val dataTradeStart: String?,
    @Json(name = "data_trade_end") val dataTradeEnd: String?,
    @Json(name = "data_symbols_count") val dataSymbolsCount: String?,
    @Json(name = "volume_1hrs_usd") val volumeOneHoursUsd: String?,
    @Json(name = "volume_1day_usd") val volumeOneDayUsd: String?,
    @Json(name = "volume_1mth_usd") val volumeOneMonthUsd: String?,
    @Json(name = "price_usd") val priceUsd: String?,
    @Json(name = "id_icon") val iconId: String?) : Parcelable