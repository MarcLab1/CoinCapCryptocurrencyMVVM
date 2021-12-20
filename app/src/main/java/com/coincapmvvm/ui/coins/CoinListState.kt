package com.coincapmvvm.ui.coins

import com.coincapmvvm.domain.model.Coin


data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)