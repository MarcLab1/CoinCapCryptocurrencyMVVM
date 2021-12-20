package com.coincapmvvm.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CoinResponseDto(

    @SerializedName("data")
    var coin : CoinDto

)