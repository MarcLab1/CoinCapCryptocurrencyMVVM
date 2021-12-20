package com.coincapmvvm.di

import com.coincapmvvm.common.Constants
import com.coincapmvvm.data.remote.CoinCapApi
import com.coincapmvvm.data.repository.CoinRepositoryImpl
import com.coincapmvvm.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCapApi(): CoinCapApi {
        return Retrofit.Builder()
            .baseUrl(Constants.URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinCapApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinCapApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}