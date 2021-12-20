package com.coincapmvvm.domain.repository

import com.coincapmvvm.data.remote.dto.CoinDto
import com.coincapmvvm.data.remote.dto.CoinsResponseDto
import com.coincapmvvm.data.remote.dto.CoinResponseDto

interface CoinRepository {

    suspend fun getCoins() : List<CoinDto>
    suspend fun getCoinsResponse() : CoinsResponseDto
    suspend fun getCoinResponse(coinId: String): CoinResponseDto
    suspend fun getCoinById(coinId: String): CoinDto
}