package com.coincapmvvm.data.repository

import com.coincapmvvm.data.remote.CoinCapApi
import com.coincapmvvm.data.remote.dto.CoinDto
import com.coincapmvvm.data.remote.dto.CoinsResponseDto
import com.coincapmvvm.data.remote.dto.CoinResponseDto
import com.coincapmvvm.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api : CoinCapApi

) : CoinRepository{

    override suspend fun getCoins() : List<CoinDto>
    {
        return api.getCoinsResponse().coins
    }

    override suspend fun getCoinsResponse() : CoinsResponseDto
    {
        return api.getCoinsResponse()
    }

    override suspend fun getCoinResponse(coinId : String): CoinResponseDto{
        return api.getCoinResponse(coinId)
    }

    override suspend fun getCoinById(coinId: String): CoinDto {
       return api.getCoinResponse(coinId).coin
    }


}