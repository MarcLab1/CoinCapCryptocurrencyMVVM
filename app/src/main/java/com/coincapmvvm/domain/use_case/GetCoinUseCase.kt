package com.coincapmvvm.domain.use_case

import com.coincapmvvm.common.Resource
import com.coincapmvvm.domain.model.Coin
import com.coincapmvvm.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<Coin>> = flow {
        try {
            emit(Resource.Loading<Coin>())
            val coin = repository.getCoinById(coinId)
            emit(Resource.Success<Coin>(coin.toCoin()))
        } catch(e: HttpException) {
            emit(Resource.Error<Coin>(e.localizedMessage ?: "Error"))
        } catch(e: IOException) {
            emit(Resource.Error<Coin>("No internet connection"))
        }
    }
}