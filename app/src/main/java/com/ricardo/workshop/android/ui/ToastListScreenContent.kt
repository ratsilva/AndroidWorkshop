package com.ricardo.workshop.android.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ricardo.workshop.android.R
import com.ricardo.workshop.android.common.CurrencyFormatter
import com.ricardo.workshop.android.common.DateTimeFormatter
import com.ricardo.workshop.android.data.Toast
import java.math.BigDecimal


@Composable
internal fun ToastListScreenContent(
    modifier: Modifier = Modifier,
    uiState: ToastListViewModel.UiState
) {
    when (uiState) {
        is ToastListViewModel.UiState.Content -> {
            LazyColumn(modifier = modifier.fillMaxSize()) {
                items(uiState.toasts.size) { position ->
                    ToastItem(uiState.toasts[position])
                    HorizontalDivider(
                        color = colorResource(R.color.light_grey),
                        thickness = 0.5.dp,
                    )
                }
            }
        }

        is ToastListViewModel.UiState.Error -> Text(uiState.errorMessage)
        ToastListViewModel.UiState.Loading -> CircularProgressIndicator()
    }
}

@Composable
internal fun ToastItem(toast: Toast) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(24.dp)
                .background(colorResource(R.color.black), shape = RoundedCornerShape(56.dp))
        ) {
            Text(
                text = toast.id.toString(),
                color = colorResource(R.color.white),
            )
        }
        Column(
            modifier = Modifier
                .padding(start = 16.dp)
        ) {
            Text(
                text = toast.name,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.black)
            )
            Text(
                text = CurrencyFormatter.format(toast.currency, toast.price),
                color = colorResource(R.color.mid_grey)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = DateTimeFormatter.format(toast.lastSold),
            color = colorResource(R.color.mid_grey),
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
internal fun ToastListScreenContentPreview() {
    ToastListScreenContent(
        uiState = ToastListViewModel.UiState.Content(
            toasts = listOf(
                Toast(
                    id = 1,
                    name = "Banana",
                    price = BigDecimal("5.99"),
                    currency = "USD",
                    lastSold = "2021-01-30T02:24:04Z"
                ),
                Toast(
                    id = 2,
                    name = "Bacon",
                    price = BigDecimal("9.99"),
                    currency = "BRL",
                    lastSold = "2022-01-30T02:24:04Z"
                )
            )
        )
    )
}

@Composable
@Preview(showBackground = true)
internal fun ToastListScreenContentLoadingPreview() {
    ToastListScreenContent(
        uiState = ToastListViewModel.UiState.Loading
    )
}