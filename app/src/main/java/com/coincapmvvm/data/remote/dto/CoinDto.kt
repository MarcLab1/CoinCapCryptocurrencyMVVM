package com.coincapmvvm.data.remote.dto

import com.coincapmvvm.domain.model.Coin
import com.google.gson.annotations.SerializedName

data class CoinDto(
    val id: String,
    val rank: String,
    val symbol: String,
    val name: String,
    val supply: String,
    val maxSupply: String? = "",
    val marketCapUsd: String? = "",
    val volumeUsd24Hr: String? = "",
    val priceUsd: String,
    val changePercent24Hr: String? = "",
    val vwap24Hr: String? = "",
    val explorer: String? = ""
) {
    fun toCoin(): Coin {
        return Coin(id, rank, symbol, name,
            supply?.let { getDoubleFormatted(it, 1) },
            maxSupply?.let { getDoubleFormatted(it, 1) },
            marketCapUsd?.let { getDoubleFormatted(it, 1) },
            volumeUsd24Hr?.let { getDoubleFormatted(it, 1) },
            priceUsd?.let { getDoubleFormatted(it, 2) },
            changePercent24Hr?.let { getDoubleFormatted(it, 2) },
            vwap24Hr?.let { getDoubleFormatted(it, 1) }, explorer)
    }

    private fun getDoubleFormatted(number: String, numberDecimals: Int) : String
    {
        return String.format("%.${numberDecimals.toString()}f", number.toDouble())
    }

    /*
    private fun getPercentFormatted(number: String) : String
    {   var newNumber = number.toDouble() * 100
        return String.format("%.1f", newNumber) + "%"
    }

     */

}