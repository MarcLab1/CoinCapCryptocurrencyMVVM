package com.coincapmvvm.ui.coin_detail


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.coincapmvvm.domain.model.Coin

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    val ctx = LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item() {
                state.coin?.let {
                    CoinDetailItem(
                        coin = it
                    )
                }
            }
        }

        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Composable
fun CoinDetailItem(
    coin: Coin
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        verticalArrangement = Arrangement.SpaceEvenly,

        ) {
        Text(
            text = "Rank = ${coin.rank}"
        )
        Text(
            text = "Name = ${coin.name}"
        )
        Text(
            text = "Symbol = ${coin.symbol}"
        )
        Text(
            text = "Price (USD) = ${coin.priceUsd}"
        )
        Text(
            text = "Supply = ${coin.supply}"
        )
        Text(
            text = "Max Supply = ${coin.maxSupply}"
        )
        Text(
            text = "Volume (24hrs) = ${coin.volumeUsd24Hr}"
        )
        Text(
            text = "Change Percent (24hrs) = ${coin.changePercent24Hr}"
        )
        Text(
            text = "VWap (24hrs) = ${coin.vwap24Hr}"
        )
    }
}