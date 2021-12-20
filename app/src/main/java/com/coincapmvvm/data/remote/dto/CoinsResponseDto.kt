package com.coincapmvvm.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CoinsResponseDto(

    @SerializedName("data")
    var coins : List<CoinDto>

)