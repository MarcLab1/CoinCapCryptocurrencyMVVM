package com.coincapmvvm.data.remote

import com.coincapmvvm.data.remote.dto.CoinsResponseDto
import com.coincapmvvm.data.remote.dto.CoinResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinCapApi {

    @GET("/v2/assets?limit=30")  //limiting response to 30 coins for demo purposes
    suspend fun getCoinsResponse(): CoinsResponseDto

    @GET("/v2/assets/{coinId}")
    suspend fun getCoinResponse(@Path("coinId") coinId: String): CoinResponseDto
}