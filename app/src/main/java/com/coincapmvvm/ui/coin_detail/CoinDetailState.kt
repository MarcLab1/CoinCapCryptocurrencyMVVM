package com.coincapmvvm.ui.coin_detail

import com.coincapmvvm.domain.model.Coin

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: Coin? = null,
    val error: String = ""
)